"""
This is the script for running the Stage 3 of the project:
Predictive Data Analysis

Team14:
Kirill Batyshchev k.batyshchev@innopolis.university
Viktor Kovalev vi.kovalev@innopolis.university
Nagim Isyanbaev n.isyanbaev@innopolis.university

Spring 2024
Introduction to Big Data
Innopolis University
Russia
"""
import gc
import math
import os

from math import radians
from pprint import pprint
from pyspark import keyword_only
from pyspark.ml import Transformer, Pipeline
from pyspark.ml.evaluation import RegressionEvaluator
from pyspark.ml.feature import VectorAssembler, RobustScaler, OneHotEncoder, VectorIndexer
from pyspark.ml.param.shared import HasInputCol, HasOutputCol
from pyspark.ml.regression import LinearRegression, RandomForestRegressor
from pyspark.ml.tuning import ParamGridBuilder, CrossValidator
from pyspark.ml.util import DefaultParamsReadable
from pyspark.sql import SparkSession
from pyspark.sql.functions import col, when, from_unixtime, month, dayofmonth, sin, cos, udf
from pyspark.sql.types import ArrayType, DoubleType

# Add here your team number teamx
TEAM = "team14"

# location of your Hive database in HDFS
WAREHOUSE = "project/hive/warehouse"

spark = SparkSession.builder\
        .appName(f"{TEAM} - spark ML")\
        .master("yarn")\
        .config("hive.metastore.uris", "thrift://hadoop-02.uni.innopolis.ru:9883")\
        .config("spark.sql.warehouse.dir", WAREHOUSE)\
        .config("spark.sql.avro.compression.codec", "snappy")\
        .config("spark.shuffle.service.enabled", "false")\
        .config("spark.dynamicAllocation.enabled", "false")\
        .config("spark.cores.max", "5")\
        .config("spark.executor.instances","5")\
        .config("spark.executor.memory","8g")\
        .config("spark.executor.cores","5")\
        .enableHiveSupport()\
        .getOrCreate()

spark.sql("SHOW DATABASES").show()

spark.sql("USE team14_projectdb")
spark.sql("SHOW TABLES").show()

spark.sql("SELECT * FROM team14_projectdb.houses_part").show()

spark.sql("SELECT * FROM team14_projectdb.real_estate_announcements_buck").show()

HOUSES = spark.read.format("avro").table('team14_projectdb.houses_part')

LISTINGS = spark.read.format("avro").table('real_estate_announcements_buck')

HOUSES.printSchema()

LISTINGS.printSchema()

# Take only the Tatarstan flats, as there are too many instances
HOUSES = HOUSES.filter(HOUSES.id_region == 16)

df = HOUSES.join(LISTINGS, HOUSES.house_id == LISTINGS.house_id)

# The house_id is NOT a FEATURE, but a joining point. So, it is not needed after joining
# because all the info about house is reflected in the other features
# Region id contains only a single value after filtering the Tatarstan data
df = df.drop(LISTINGS['house_id'])
df = df.drop('house_id', 'id_region')

df.show()

HOUSES = None
LISTINGS = None
gc.collect()

# Announcement id is a unique identifier, so we do not include it
# publication_date and geo_* features will be transformed
# Street_id and postal_code are categorical columns, but we cannot use them
# as OneHot encoded as there are too many unique values (several thousands)
# level, levels, rooms, area are categorical, but they have strict numerical order,
# so we won't encode them, but treat as numerical instead
numerical = ['street_id', 'postal_code', 'level', 'levels', 'rooms', 'area', 'kitchen_area']
categorical = ['building_type', 'object_type']
transformable_features = ['geo_lon', 'geo_lat', 'publication_date']

# We aim to predict the price
LABEL = 'price'

# Drop entries with null values
df = df.select(numerical + categorical + transformable_features + [LABEL]).na.drop()

# Drop duplicates
df = df.dropDuplicates()

# Translate the label column
df = df.withColumnRenamed(LABEL,"label")

# Replace -100 and -1 (studio appartment) with zeros
df = df.withColumn("kitchen_area", when(col("kitchen_area") == -100, 0)\
                   .otherwise(col("kitchen_area")))
df = df.withColumn("rooms", when(col("rooms") == -1, 0).otherwise(col("rooms")))

# Filter outliers. Even the smallest flats cannot cost less than 500,000,
# so it is probably malformed data, and flats that cost more than 100,000,000
# are elite flats for which the cost is determined be some extra elite
# features not included in the data, so they will confuse a model a lot
df = df.filter((col("price") >= 500_000) & (col("price") <= 100_000_000))

print("The dataframe that will be used")
df.show()

# Make sure we still satisfy the requirements
df.count()

class TimeEncoder(Transformer, HasInputCol, DefaultParamsReadable):
    """
    A custom transformer to encode date using sin and cos
    """
    pi = 3.141592653589793

    @keyword_only
    def __init__(self, **kwargs):
        super().__init__()
        self._setDefault(inputCol="publication_date")
        # kwargs = self._input_kwargs
        self._set(**kwargs)


    def getInputCol(self):
        return self.getOrDefault(self.inputCol)

    def _transform(self, dataset):
        # Convert timestamp to date format
        dataset = dataset.withColumn("date", from_unixtime(col(self.getInputCol())))

        # Extract month, and day of month
        dataset = dataset.withColumn("month", month(col("date"))) \
                         .withColumn("day", dayofmonth(col("date")))

        # Encode month, day using sine and cosine functions
        dataset = dataset.withColumn("month_sin", sin(col("month") * (2 * self.pi / 12))) \
                         .withColumn("month_cos", cos(col("month") * (2 * self.pi / 12))) \
                         .withColumn("day_sin", sin(col("day") * (2 * self.pi / 31))) \
                         .withColumn("day_cos", cos(col("day") * (2 * self.pi / 31)))

        # Drop intermediate columns
        dataset = dataset.drop(self.getInputCol(), "date", "month", "day")
        return dataset


class GeoToECEF(Transformer, HasOutputCol, DefaultParamsReadable):
    """
    Custom transformer to encode longtitude and latitude columns to the
    ECEF format
    """
    @keyword_only
    def __init__(self, **kwargs):
        super().__init__()
        self._setDefault(outputCol="ecef_coordinates")
        # kwargs = self._input_kwargs
        self._set(**kwargs)

    def getOutputCol(self):
        return self.getOrDefault(self.outputCol)

    def _transform(self, dataset):
        def geo_to_ecef(lat, lon):
            a_cst = 6378137.0  # WGS-84 semi-major axis
            e_2 = 6.6943799901377997e-3  # WGS-84 first eccentricity squared

            lat_rad = radians(lat)
            lon_rad = radians(lon)

            n_cst = a_cst / ((1 - e_2 * (math.sin(lat_rad) ** 2)) ** 0.5)
            ecef_x = n_cst * math.cos(lat_rad) * math.cos(lon_rad)
            ecef_y = n_cst * math.cos(lat_rad) * math.sin(lon_rad)
            ecef_z = n_cst * (1 - e_2) * math.sin(lat_rad)
            return [ecef_x, ecef_y, ecef_z]

        geo_to_ecef_udf = udf(geo_to_ecef, ArrayType(DoubleType()))
        dataset = dataset.withColumn(
            self.getOutputCol(),
            geo_to_ecef_udf(dataset["geo_lat"], dataset["geo_lon"])
        )
        return dataset

class Disassembler(Transformer):
    """
    A custom transformer to disassemble a list column to a list of columns
    """

    def __init__(self, inputCol, outputCol):
        super().__init__()
        self.input_col = inputCol
        self.output_col = outputCol

    def _transform(self, dataset):
        for i, column in enumerate(self.output_col):
            dataset = dataset.withColumn(column, col(self.input_col)[i])
        return dataset.drop(self.input_col)

# No point to have hours, minutes, seconds, as they are not included into
# the data and will be all zeros
# Year is also the same everywhere
time_features = ["month_sin", "month_cos", "day_sin", "day_cos"]

ecef_features = ["ecef_x", "ecef_y", "ecef_z"]

# Encode the categorical data
encoders = [ OneHotEncoder(inputCol=c, outputCol=f"{c}_encoded") for c in categorical]

# Assemble the features to one column
assembler = VectorAssembler(
    inputCols=numerical+[f"{c}_encoded" for c in categorical]+time_features+ecef_features,
    outputCol="unscaled_features"
)

# Scalr the features using the robust scaler
scaler = RobustScaler(inputCol="unscaled_features", outputCol="features")

# Pipeline to execute transformations
pipeline = Pipeline(stages=[
    TimeEncoder(),
    GeoToECEF(),
    Disassembler("ecef_coordinates", ecef_features)
] + encoders + [assembler, scaler])

# Fit the pipeline to the data
pipeline_model = pipeline.fit(df)

# Apply transformations
TRANSFORMED_DF = pipeline_model.transform(df)

print("The transformed dataframe with all stages")
TRANSFORMED_DF.show(truncate=False)

DATA = TRANSFORMED_DF.select(['features', 'label'])

featureIndexer = VectorIndexer(
    inputCol="features",
    outputCol="indexedFeatures",
    maxCategories=7
).fit(DATA)
TRANSFORMED = featureIndexer.transform(DATA)

print("The final training dataframe")
# Display the output Spark DataFrame
TRANSFORMED.show()

DATA = None
TRANSFORMED_DF = None
# df = None
gc.collect()

def run(command):
    """
    A function to run commands in shell
    """
    return os.popen(command).read()

(train_data, test_data) = TRANSFORMED.randomSplit([0.7, 0.3], seed = 10)

train_data.select("features", "label")\
    .coalesce(1)\
    .write\
    .mode("overwrite")\
    .format("json")\
    .save("project/data/train")

# Run it from root directory of the repository
run("hdfs dfs -cat project/data/train/*.json > data/train.json")

test_data.select("features", "label")\
    .coalesce(1)\
    .write\
    .mode("overwrite")\
    .format("json")\
    .save("project/data/test")

# Run it from root directory of the repository
run("hdfs dfs -cat project/data/test/*.json > data/test.json")

TRANSFORMED = None
gc.collect()

lr = LinearRegression(
    featuresCol="indexedFeatures",
    labelCol="label",
    elasticNetParam=1,
    fitIntercept=False
)
model_lr= lr.fit(train_data)

PRED_LR = model_lr.transform(test_data)

print("Base Linear Regression model predictions")
PRED_LR.show()

# Evaluate the performance of the model
evaluator_rmse = RegressionEvaluator(
    labelCol="label",
    predictionCol="prediction",
    metricName="rmse"
)
evaluator_r2 = RegressionEvaluator(
    labelCol="label",
    predictionCol="prediction",
    metricName="r2"
)
evaluator_mae = RegressionEvaluator(
    labelCol="label",
    predictionCol="prediction",
    metricName="mae"
)

rmse = evaluator_rmse.evaluate(PRED_LR)
r2 = evaluator_r2.evaluate(PRED_LR)
mae = evaluator_mae.evaluate(PRED_LR)

print("The metrics of base linear regression model on the test data")
print("Root Mean Squared Error (RMSE) =", rmse)
print("Mean absolute error (MAE) =", mae)
print("R-squared score =", r2)

param_grid = (ParamGridBuilder()
              .addGrid(lr.fitIntercept, [False, True])  # whether to use intercept
              .addGrid(lr.aggregationDepth, [2, 3, 4])  # maximal number of terms to use
              .build())

# Create CrossValidator
cv = CrossValidator(estimator=lr,
                    estimatorParamMaps=param_grid,
                    evaluator=evaluator_rmse,
                    numFolds=3,
                    parallelism=5,
                    seed=10)


# Fit CrossValidator
cv_model = cv.fit(train_data)

# Get the best Random Forest model
best_lr_model = cv_model.bestModel

# cv = None
# gc.collect()

print("Parameters of the best Linear Regression model")
model1 = best_lr_model
pprint(model1.extractParamMap())

model1.write().overwrite().save("project/models/model1")

# Run it from root directory of the repository
run("hdfs dfs -get project/models/model1 models/model1")

PREDICTIONS1 = model1.transform(test_data)
print("Predicitons of the best random forest model")
PREDICTIONS1.show()

PREDICTIONS1.select("label", "prediction")\
    .coalesce(1)\
    .write\
    .mode("overwrite")\
    .format("csv")\
    .option("sep", ",")\
    .option("header","true")\
    .save("project/output/model1_predictions.csv")

# Run it from root directory of the repository
run("hdfs dfs -cat project/output/model1_predictions.csv/*.csv" +
    " > output/model1_predictions.csv")

rmse1 = evaluator_rmse.evaluate(PREDICTIONS1)
mae1 = evaluator_mae.evaluate(PREDICTIONS1)
r2_1 = evaluator_r2.evaluate(PREDICTIONS1)

print("Evaluating the best linear regression model on the test set")
print("Root Mean Squared Error (RMSE) =", rmse1)
print("Mean absolute error (MAE) =", mae1)
print("R-squared score =", r2_1)

rf = RandomForestRegressor(
    featuresCol="indexedFeatures",
    labelCol="label",
    seed=10
)
model_rf= rf.fit(train_data)

PRED_RF = model_rf.transform(test_data)

print("Base random forest model predictions:")
PRED_RF.show()

rmse_rf = evaluator_rmse.evaluate(PRED_RF)
mae_rf = evaluator_mae.evaluate(PRED_RF)
r2_rf = evaluator_r2.evaluate(PRED_RF)

print("Base Random Forest model metrics on test set")
print("Root Mean Squared Error (RMSE) =", rmse_rf)
print("Mean Absolute Error (MAE) =", mae_rf)
print("R-squared score =", r2_rf)

PRED_LR = None
# predicitons1 = None
PRED_RF = None
gc.collect()

param_grid = (ParamGridBuilder()
              .addGrid(rf.maxDepth, [10, 5])  # number of trees
              .addGrid(rf.numTrees, [50, 25])  # maximum depth of trees
              .build())

# Create CrossValidator
cv = CrossValidator(estimator=rf,
                    estimatorParamMaps=param_grid,
                    evaluator=evaluator_rmse,
                    numFolds=3,
                    parallelism=5,
                    seed=10)


# Fit CrossValidator
cv_model = cv.fit(train_data)

# Get the best Random Forest model
best_rf_model = cv_model.bestModel

print("Parameters of the best Random Forest model")
model2 = best_rf_model
pprint(model2.extractParamMap())

model2.write().overwrite().save("project/models/model2")

# Run it from root directory of the repository
run("hdfs dfs -get project/models/model2 models/model2")

PREDICTIONS2 = model2.transform(test_data)
print("Predicitons of the best random forest model")
PREDICTIONS2.show()

PREDICTIONS2.select("label", "prediction")\
    .coalesce(1)\
    .write\
    .mode("overwrite")\
    .format("csv")\
    .option("sep", ",")\
    .option("header","true")\
    .save("project/output/model2_predictions.csv")

# Run it from root directory of the repository
run("hdfs dfs -cat project/output/model2_predictions.csv/*.csv "+
    "> output/model2_predictions.csv")

rmse2 = evaluator_rmse.evaluate(PREDICTIONS2)
mae2 = evaluator_mae.evaluate(PREDICTIONS2)
r2_2 = evaluator_r2.evaluate(PREDICTIONS2)

print("Evaluating the best Random Forest model on the test set")
print("Root Mean Squared Error (RMSE) =", rmse2)
print("Mean absolute error (MAE) =", mae2)
print("R-squared score =", r2_2)

print("Compare the best models")

# Create data frame to report performance of the models
models = [[str(model1),rmse1, r2_1], [str(model2),rmse2, r2_2]]

DF = spark.createDataFrame(models, ["model", "RMSE", "R2"])
DF.show(truncate=False)


# Save it to HDFS
DF.coalesce(1)\
    .write\
    .mode("overwrite")\
    .format("csv")\
    .option("sep", ",")\
    .option("header","true")\
    .save("project/output/evaluation.csv")

# Run it from root directory of the repository
run("hdfs dfs -cat project/output/evaluation.csv/*.csv > output/evaluation.csv")

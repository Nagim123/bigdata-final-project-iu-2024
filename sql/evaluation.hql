USE team14_projectdb;

DROP TABLE IF EXISTS model1_predictions;

CREATE EXTERNAL TABLE model1_predictions(
label INTEGER,
prediction FLOAT)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
location 'project/hive/warehouse/model1_predictions'
tblproperties("skip.header.line.count"="1");

LOAD DATA INPATH '/user/team14/project/output/model1_predictions_copy.csv' INTO TABLE model1_predictions;

SELECT * FROM model1_predictions limit 10;

DROP TABLE IF EXISTS model2_predictions;

CREATE EXTERNAL TABLE model2_predictions(
label INTEGER,
prediction FLOAT)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
location 'project/hive/warehouse/model2_predictions'
tblproperties("skip.header.line.count"="1");

LOAD DATA INPATH '/user/team14/project/output/model2_predictions_copy.csv' INTO TABLE model2_predictions;

SELECT * FROM model2_predictions limit 10;

DROP TABLE IF EXISTS evaluation;

CREATE EXTERNAL TABLE evaluation(
model STRING,
rmse FLOAT,
r2 FLOAT)
ROW FORMAT SERDE 'org.apache.hadoop.hive.serde2.OpenCSVSerde'
WITH SERDEPROPERTIES (
    "separatorChar" = ",",
    "quoteChar"     = "\""
)
location 'project/hive/warehouse/evaluation'
tblproperties("skip.header.line.count"="1");

LOAD DATA INPATH '/user/team14/project/output/evaluation_copy.csv' INTO TABLE evaluation;

SELECT * FROM evaluation;
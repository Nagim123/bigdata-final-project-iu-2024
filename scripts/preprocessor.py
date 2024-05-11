"""
Script to do preprocessing on the DATASET.
Basically to separate DATASET into 2 tables.
"""
import gc
import pandas as pd
import numpy as np

# Read initial DATASET
print("Preprocessing step 0/4: Reading initial DATASET")
DATASET = pd.read_csv("data/input_data.csv", sep=";")
DATASET.insert(0, "announcement_id", range(1, DATASET.shape[0] + 1))

# Extract only features related to houses
houses_features = [
    "house_id",
    "id_region",
    "street_id",
    "postal_code",
    "building_type",
    "geo_lon",
    "geo_lat",
    "object_type",
    "announcement_id"
]

houses_df = DATASET[houses_features]

# Extract only real estate announcements
announcements_features = [
    "announcement_id",
    "date",
    "price",
    "level",
    "levels",
    "rooms",
    "area",
    "kitchen_area"
]

real_estate_announcements = DATASET[announcements_features]

DATASET = None
gc.collect()

# Remove duplicates and remove unknown type buildings ('building_type' = 0)
# if we had houses with known 'building_type'

print("Preprocessing step 1/4: Creating houses dataframe")

GROUPING_FEATURES = set(houses_features).difference(["announcement_id",
                                                     "building_type"])
GROUPING_FEATURES = list(GROUPING_FEATURES)
houses_df = houses_df.fillna("NaN")
houses_df = houses_df.groupby(GROUPING_FEATURES) \
                .agg({"announcement_id": list, "building_type": "max"}) \
                .reset_index()
houses_df = houses_df.replace("NaN", np.nan)

# Add missing ID's to houses
max_house_id = int(houses_df["house_id"].max())
missing_id_count = len(houses_df[houses_df["house_id"].isna()])

MISSING_IDS = range(max_house_id, max_house_id + missing_id_count)
houses_df.loc[houses_df["house_id"].isna(), "house_id"] = MISSING_IDS

MISSING_IDS = None
GROUPING_FEATURES = None
gc.collect()

# Remove outdated information about 'object_type', keep only recent one
print("Preprocessing step 2/4: Removing duplicated houses")
houses_df.drop_duplicates(subset=["house_id", "object_type"], keep="last")

# Drop repeating samples
houses_df = houses_df.drop_duplicates("house_id")

# Add house id feature
print("Preprocessing step 3/4: Linking houses dataframe with\
 announcements table through house id")

EXPLODED_HOUSE_ID = houses_df[["announcement_id", "house_id"]]
EXPLODED_HOUSE_ID = pd.DataFrame(
    {'house_id': EXPLODED_HOUSE_ID.house_id.
     repeat(EXPLODED_HOUSE_ID.announcement_id.str.len()),
     'announcement_id': np.concatenate(EXPLODED_HOUSE_ID
                                       .announcement_id.values)})

real_estate_announcements = real_estate_announcements. \
            merge(EXPLODED_HOUSE_ID, how="inner", on="announcement_id")

EXPLODED_HOUSE_ID = None
gc.collect()

# Drop announcement id from houses
houses_df = houses_df.drop("announcement_id", axis=1)

# Convert datatypes
print("Preprocessing step 4/4: Converting data and saving on disk")

houses_df["house_id"] = houses_df["house_id"].astype(int)
houses_df["id_region"] = houses_df["id_region"].astype("Int64")
houses_df["street_id"] = houses_df["street_id"].astype("Int64")
houses_df["postal_code"] = houses_df["postal_code"].astype("Int64")
houses_df["building_type"] = houses_df["building_type"].astype(int)
houses_df["object_type"] = houses_df["object_type"].astype(int)

houses_df = houses_df[houses_features[:-1]]

real_estate_announcements["announcement_id"] = \
    real_estate_announcements["announcement_id"].astype(int)

real_estate_announcements["price"] = \
    real_estate_announcements["price"].astype(int)

real_estate_announcements["level"] = \
    real_estate_announcements["level"].astype(int)
real_estate_announcements["levels"] = \
    real_estate_announcements["levels"].astype(int)
real_estate_announcements["rooms"] = \
    real_estate_announcements["rooms"].astype(int)
real_estate_announcements["house_id"] = \
    real_estate_announcements["house_id"].astype(int)

real_estate_announcements = \
    real_estate_announcements[announcements_features + ["house_id"]]

# Save dataframes
houses_df.to_csv("data/houses.csv", index=None)
real_estate_announcements.to_csv("data/real_estate_announcements.csv",
                                 index=None)

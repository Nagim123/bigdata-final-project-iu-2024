DROP DATABASE IF EXISTS team14_projectdb CASCADE;

CREATE DATABASE team14_projectdb LOCATION "project/hive/warehouse";
USE team14_projectdb;


-- Create tables
-- houses table
CREATE EXTERNAL TABLE houses STORED AS AVRO LOCATION 'project/warehouse/houses' TBLPROPERTIES ('avro.schema.url'='project/warehouse/avsc/houses.avsc');

-- real estates table
CREATE EXTERNAL TABLE real_estate_announcements STORED AS AVRO LOCATION 'project/warehouse/real_estate_announcements' TBLPROPERTIES ('avro.schema.url'='project/warehouse/avsc/real_estate_announcements.avsc');

-- For checking the content of tables
SELECT * FROM houses LIMIT 5;
SELECT * FROM real_estate_announcements LIMIT 5;

-- Partitioning
-- settings
SET hive.exec.dynamic.partition=true;
SET hive.exec.dynamic.partition.mode=nonstrict;


-- Create houses table with partitioning by object_type
CREATE EXTERNAL TABLE houses_part (
    house_id INTEGER, id_region SMALLINT, street_id INTEGER, postal_code INTEGER, building_type SMALLINT, geo_lon FLOAT, geo_lat FLOAT
)
PARTITIONED BY (object_type SMALLINT) STORED AS AVRO LOCATION 'project/hive/warehouse/houses_part' TBLPROPERTIES ('AVRO.COMPRESS'='SNAPPY');

-- Insert data into houses table while specifying partition values
INSERT OVERWRITE TABLE houses_part PARTITION (object_type)
SELECT house_id, id_region, street_id, postal_code, building_type, geo_lon, geo_lat, object_type
FROM houses;


-- Bucketing
CREATE EXTERNAL TABLE real_estate_announcements_buck (
    announcement_id INTEGER, publication_date BIGINT, price BIGINT, level SMALLINT, levels SMALLINT, rooms SMALLINT, area DECIMAL(6, 3), kitchen_area DECIMAL(6, 3), house_id INTEGER
)
CLUSTERED BY (announcement_id) into 7 buckets 
STORED AS AVRO LOCATION 'project/hive/warehouse/real_estate_announcements_buck' TBLPROPERTIES ('AVRO.COMPRESS'='SNAPPY');

INSERT OVERWRITE TABLE real_estate_announcements_buck
SELECT announcement_id, publication_date as publication_date, price, level, levels, rooms, area, kitchen_area, house_id
FROM real_estate_announcements;


-- Checking
-- Select data from the houses_part partitioned by object_type
SELECT * FROM houses_part LIMIT 5;
SELECT * FROM houses_part WHERE object_type = 2 LIMIT 5;

-- Select data from the real_estate_announcements_buck clustered by announcement_id
SELECT * FROM real_estate_announcements_buck LIMIT 5;
SELECT * FROM real_estate_announcements_buck WHERE announcement_id = 2 LIMIT 5;

DROP TABLE houses;
DROP TABLE real_estate_announcements;

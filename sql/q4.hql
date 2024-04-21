USE team14_projectdb;

DROP TABLE IF EXISTS q4_results;

CREATE EXTERNAL TABLE q4_results(
building_type SMALLINT,
avg_price BIGINT)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
location 'project/hive/warehouse/q4';

-- to not display table names with column names
SET hive.resultset.use.unique.column.names = false;

INSERT INTO q4_results
SELECT h.building_type, AVG(ra.price) AS avg_price
FROM real_estate_announcements_buck ra
JOIN houses_part h ON ra.house_id = h.house_id
GROUP BY h.building_type;

INSERT OVERWRITE DIRECTORY 'project/output/q4'
ROW FORMAT DELIMITED FIELDS
TERMINATED BY ','
SELECT * FROM q4_results;

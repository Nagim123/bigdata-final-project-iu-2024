USE team14_projectdb;

DROP TABLE IF EXISTS q3_results;

CREATE EXTERNAL TABLE q3_results(
area DECIMAL(6, 3),
avg_price BIGINT)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
location 'project/hive/warehouse/q3';

-- to not display table names with column names
SET hive.resultset.use.unique.column.names = false;

INSERT INTO q3_results
SELECT ra.area, AVG(ra.price) AS avg_price
FROM real_estate_announcements_buck ra
GROUP BY ra.area;

INSERT OVERWRITE DIRECTORY 'project/output/q3'
ROW FORMAT DELIMITED FIELDS
TERMINATED BY ','
SELECT * FROM q3_results;

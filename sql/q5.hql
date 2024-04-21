USE team14_projectdb;

DROP TABLE IF EXISTS q5_results;

CREATE EXTERNAL TABLE q5_results(
object_type SMALLINT,
avg_price BIGINT)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
location 'project/hive/warehouse/q5';

-- to not display table names with column names
SET hive.resultset.use.unique.column.names = false;

INSERT INTO q5_results
SELECT h.object_type, AVG(ra.price) AS avg_price
FROM real_estate_announcements_buck ra
JOIN houses_part h ON ra.house_id = h.house_id
GROUP BY h.object_type;

INSERT OVERWRITE DIRECTORY 'project/output/q5'
ROW FORMAT DELIMITED FIELDS
TERMINATED BY ','
SELECT * FROM q5_results;

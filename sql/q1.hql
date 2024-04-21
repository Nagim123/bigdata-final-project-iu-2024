USE team14_projectdb;

DROP TABLE IF EXISTS q1_results;

CREATE EXTERNAL TABLE q1_results(
level SMALLINT,
avg_price BIGINT)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
location 'project/hive/warehouse/q1';

-- to not display table names with column names
SET hive.resultset.use.unique.column.names = false;

INSERT INTO q1_results
SELECT ra.level, AVG(ra.price) AS avg_price
FROM real_estate_announcements_buck ra
GROUP BY ra.level;

INSERT OVERWRITE DIRECTORY 'project/output/q1' 
ROW FORMAT DELIMITED FIELDS 
TERMINATED BY ',' 
SELECT * FROM q1_results;

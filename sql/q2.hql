USE team14_projectdb;

DROP TABLE IF EXISTS q2_results;

CREATE EXTERNAL TABLE q2_results(
rooms SMALLINT,
avg_price BIGINT)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
location 'project/hive/warehouse/q2';

-- to not display table names with column names
SET hive.resultset.use.unique.column.names = false;

INSERT INTO q2_results
SELECT ra.rooms, AVG(ra.price) AS avg_price
FROM real_estate_announcements_buck ra
GROUP BY ra.rooms;

INSERT OVERWRITE DIRECTORY 'project/output/q2'
ROW FORMAT DELIMITED FIELDS
TERMINATED BY ','
SELECT * FROM q2_results;

USE team14_projectdb;

DROP TABLE IF EXISTS my_json_table;
DROP TABLE IF EXISTS test_data;

CREATE EXTERNAL TABLE my_json_table (
    json_data STRING
)
ROW FORMAT DELIMITED
LOCATION 'project/hive/warehouse/tempjson';

LOAD DATA INPATH '/user/team14/project/data/test_copy' INTO TABLE my_json_table;

CREATE EXTERNAL TABLE test_data(
    vector_values STRING,
    indices STRING,
    size STRING,
    type STRING,
    label STRING
)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY '|'
LOCATION 'project/hive/warehouse/test_data';

INSERT OVERWRITE TABLE test_data SELECT 
    get_json_object(json_data, '$.features.values') AS vector_values,
    get_json_object(json_data, '$.features.indices') AS indices,
    get_json_object(json_data, '$.features.size') AS size,
    get_json_object(json_data, '$.features.type') AS type,
    get_json_object(json_data, '$.label') AS label
FROM my_json_table;


SELECT * FROM test_data LIMIT 20;
#!/bin/bash

hdfs dfs -rm -f -R -skipTrash /user/team14/project/warehouse/avsc/*

hdfs dfs -mkdir -p project/warehouse/avsc
hdfs dfs -put output/*.avsc project/warehouse/avsc


password=$(head -n 1 secrets/.hive.pass)

beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team14 -p $password -f sql/db.hql > output/hive_results.txt

hdfs dfs -rm -r -f project/warehouse/houses
hdfs dfs -rm -r -f project/warehouse/real_estate_announcements


# insight 1
beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team14 -p $password -f sql/q1.hql
echo "level,avg_price" > output/q1.csv
hdfs dfs -cat project/output/q1/* >> output/q1.csv

# insight 2
beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team14 -p $password -f sql/q2.hql
echo "rooms,avg_price" > output/q2.csv
hdfs dfs -cat project/output/q2/* >> output/q2.csv

# insight 3
beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team14 -p $password -f sql/q3.hql
echo "area,avg_price" > output/q3.csv
hdfs dfs -cat project/output/q3/* >> output/q3.csv

# insight 4
beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team14 -p $password -f sql/q4.hql
echo "building_type,avg_price" > output/q4.csv
hdfs dfs -cat project/output/q4/* >> output/q4.csv

# insight 5
beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team14 -p $password -f sql/q5.hql
echo "object_type,avg_price" > output/q5.csv
hdfs dfs -cat project/output/q5/* >> output/q5.csv


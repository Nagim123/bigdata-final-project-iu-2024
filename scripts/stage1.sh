#!/bin/bash
url="https://disk.yandex.ru/d/ais0k8YpTotFpQ"

rm -f data/data.zip
rm -f data/houses.csv
rm -f data/real_estate_announcements.csv

wget "$(yadisk-direct $url)" -O data/data.zip

unzip data/data.zip -d data/

rm data/data.zip

echo "building database... (please wait)"
python3 scripts/build_projectdb.py

password=$(head -n 1 secrets/.psql.pass)

hdfs dfs -mkdir -p /user/team14/project/warehouse
hdfs dfs -rm -f -R -skipTrash /user/team14/.staging
hdfs dfs -rm -f -R -skipTrash /user/team14/project/warehouse/*

sqoop import-all-tables --connect jdbc:postgresql://hadoop-04.uni.innopolis.ru/team14_projectdb --username team14 --password $password --compression-codec=snappy --compress --as-avrodatafile --warehouse-dir=/user/team14/project/warehouse --m 1

rm -f output/houses.avsc
rm -f output/houses.java
rm -f output/real_estate_announcements.avsc
rm -f output/real_estate_announcements.java

mv houses.avsc output/
mv houses.java output/
mv real_estate_announcements.avsc output/
mv real_estate_announcements.java output/

#!/bin/bash

password=$(head -n 1 secrets/.hive.pass)

hdfs dfs -rm -f -R -skipTrash /user/team14/project/output/model1_predictions_copy.csv
hdfs dfs -rm -f -R -skipTrash /user/team14/project/output/model2_predictions_copy.csv
hdfs dfs -rm -f -R -skipTrash /user/team14/project/output/evaluation_copy.csv

hdfs dfs -rm -f -R -skipTrash /user/team14/project/hive/warehouse/model1_predictions
hdfs dfs -rm -f -R -skipTrash /user/team14/project/hive/warehouse/model2_predictions
hdfs dfs -rm -f -R -skipTrash /user/team14/project/hive/warehouse/evaluation


hdfs dfs -cp /user/team14/project/output/model1_predictions.csv /user/team14/project/output/model1_predictions_copy.csv
hdfs dfs -cp /user/team14/project/output/model2_predictions.csv /user/team14/project/output/model2_predictions_copy.csv
hdfs dfs -cp /user/team14/project/output/evaluation.csv /user/team14/project/output/evaluation_copy.csv

beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team14 -p $password -f sql/evaluation.hql
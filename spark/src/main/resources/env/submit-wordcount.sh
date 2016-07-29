#!/usr/bin/env bash

cd /Users/ariyabala/spark/spark-1.5.2-bin-hadoop2.6
./bin/spark-submit --class com.ariya.poc.spark.WordCount --master local[2] /Users/ariyabala/git-ariya/BatchProcessing/spark/target/spark-1.0-SNAPSHOT.jar ~/bigdata/resources/spark/wordcount/input.txt ~/bigdata/resources/spark/wordcount/output
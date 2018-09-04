package com.huawei;

import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.api.java.JavaStreamingContext;

public class SparkStreaming {
    SparkConf sparkConf = new SparkConf().setAppName("SparkStreaming").setMaster("local[*]"); 
    JavaStreamingContext javaStreamingContext = new JavaStreamingContext(sparkConf, Durations.seconds(1000));

}

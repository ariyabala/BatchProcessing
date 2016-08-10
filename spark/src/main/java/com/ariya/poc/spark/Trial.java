package com.ariya.poc.spark;

import org.apache.spark.SparkContext;

/**
 * Created by ariyabala on 10/08/16.
 */
public class Trial {

    public static void main(String[] args) {
        String localSparkworkDir = "/Users/ariyabala/scripts/spark";
        SparkContext sc = SparkContext.getOrCreate();
        sc.setJobDescription("Trial to get used to Spark coding");
        sc.addFile(localSparkworkDir+"/pdf/capital_rule_community_bank_guide_20130709.pdf");
        sc.addJar(localSparkworkDir+"lib/jpdf2html_jun16.jar");


    }
}

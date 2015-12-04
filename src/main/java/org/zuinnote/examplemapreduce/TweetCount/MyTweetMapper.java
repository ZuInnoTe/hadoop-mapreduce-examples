package org.zuinnote.examplemapreduce.TweetCount;

/**
* Author: Jörn Franke <zuinnote@gmail.com>
*
*/
import java.io.IOException;
import org.apache.hadoop.mapred.*;
import org.apache.hadoop.io.*;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;



import java.util.*;

	 public  class MyTweetMapper  extends MapReduceBase implements Mapper<LongWritable, Text, Text, IntWritable> {
	    private final static IntWritable one = new IntWritable(1);
	    private Text word = new Text();
	        
	    public void map(LongWritable key, Text value, OutputCollector<Text, IntWritable> output, Reporter reporter) throws IOException {
	    	 String line = value.toString();
	    	 if (line.equals("")==false) {
	    	 // more elegant would be to use map/reduce counters, but for sake of simplicity and compability with the traditional wordcount example, we will use this method
	    	 word.set("tweet");
	    		 JsonElement jsonElement = new JsonParser().parse(line);
	    	 output.collect(word, one);
	    	 }
	    
	    }
	 }

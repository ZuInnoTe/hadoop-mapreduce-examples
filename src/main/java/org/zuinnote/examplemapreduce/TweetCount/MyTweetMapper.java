package org.zuinnote.examplemapreduce.TweetCount;

 import java.io.IOException;
 import org.apache.hadoop.mapreduce.*;
import org.apache.hadoop.io.*;
import java.util.*;
import com.google.gson.JsonParser;
import com.google.gson.JsonElement;

 public class MyTweetMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
    private final static IntWritable one = new IntWritable(1);
    private Text word = new Text("tweet");
        
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();
	if (line.equals("")==false) {
		// more elegant would be to use map/reduce counters, but for sake of simplicity and compability with the traditional wordcount example, we will use this method

   		 JsonElement jsonElement = new JsonParser().parse(line);
    	
            		context.write(word, one);
	}
    }
 } 

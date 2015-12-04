package org.zuinnote.examplemapreduce.TweetCount;
        

import java.io.IOException;
import java.util.*;
        
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.conf.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.*;
import org.apache.hadoop.util.*;
/**
* Author: Jörn Franke <jornfranke@gmail.com>
*
*/

public class MyTweetDriver  {

       
        
 public static void main(String[] args) throws Exception {
    JobConf conf = new JobConf(MyTweetDriver.class);
    conf.setJobName("example-hadoop-job");
    conf.setOutputKeyClass(Text.class);
    conf.setOutputValueClass(IntWritable.class);
        
    conf.setMapperClass(MyTweetMapper.class);
    conf.setReducerClass(MyTweetReducer.class);
        
    conf.setInputFormat(TextInputFormat.class);
    conf.setOutputFormat(TextOutputFormat.class);
        
    FileInputFormat.addInputPath(conf, new Path(args[0]));
    FileOutputFormat.setOutputPath(conf, new Path(args[1]));
        
    JobClient.runJob(conf);
 }
        
}

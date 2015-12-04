package org.zuinnote.examplemapreduce.WordCount;
        

import java.io.IOException;
import java.util.*;
        
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.conf.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.*;
import org.apache.hadoop.util.*;
      
/**
* Author: Jörn Franke <zuinnote@gmail.com>
*
*/

public class MyDriver  {

       
        
 public static void main(String[] args) throws Exception {
    JobConf conf = new JobConf(MyDriver.class);
    conf.setJobName("example-hadoop-job");
    conf.setOutputKeyClass(Text.class);
    conf.setOutputValueClass(IntWritable.class);
        
    conf.setMapperClass(MyMapper.class);
    conf.setReducerClass(MyReducer.class);
        
    conf.setInputFormat(TextInputFormat.class);
    conf.setOutputFormat(TextOutputFormat.class);
        
    FileInputFormat.addInputPath(conf, new Path(args[0]));
    FileOutputFormat.setOutputPath(conf, new Path(args[1]));
        
    JobClient.runJob(conf);
 }
 
}

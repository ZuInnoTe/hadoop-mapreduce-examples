hadoop-mapreduce-examples
=========================

Some simple and complex examples of mapreduce tasks for Hadoop. The main idea is to use a build tool (Gradle) and to show how standard map/reduce tasks can be executed on Hadoop2.

Build
=========================

Simply clone the repository to your local file system by using the following command:

git clone https://github.com/ZuInnoTe/hadoop-mapreduce-examples.git

Change into the directory hadoop-mapreduce-examples and execute the following command:

gradle clean build

Afterwards you will find a jar in the directory build/libs

Run on Hadoop
=========================


You should have Hadoop installed locally, run it on a cluster or leverage a cloud service, such as Amazon EMR, Google Compute or Microsoft Azure.


Wordcount
=========
You will need to create some basic input files:

echo "Hallo Hadoop Test Hadoop Test" > input

Afterwards you need to copy it to the HDFS filesystem:

hadoop fs -mkdir /tmp

hadoop fs -copyFromLocal ./input /tmp

Execute in the command line the following command:

hadoop jar build/libs/example-hadoop-0.1.0.jar org.zuinnote.examplemapreduce.WordCount.MyDriver /tmp/input /tmp/output

After some time you will see that the job successfully finished. You can see the output by using the following command:

hadoop fs -cat /tmp/output/part-r-00000

Tweetcount
=========
You will need to create some basic input files with tweets. You can either simply use JSONObjects:

echo "{\"name\":\"1\"}" > inputtweet

or you copy real tweets in JSON format into the file inputtweet. You can use the Twitter API to fetch as many tweets as you want: https://github.com/twitter/hbc

Afterwards you need to copy it to the HDFS filesystem:

hadoop fs -mkdir /tmp

hadoop fs -copyFromLocal ./inputtweet /tmp

Execute in the command line the following command:

hadoop jar build/libs/example-hadoop-0.1.0.jar org.zuinnote.examplemapreduce.TweetCount.MyTweetDriver /tmp/inputtweet /tmp/outputtweet

After some time you will see that the job successfully finished. You can see the output by using the following command:

hadoop fs -cat /tmp/outputtweet/part-r-00000

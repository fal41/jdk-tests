#!/bin/bash
mkdir tools
cd tools
wget http://www.gtlib.gatech.edu/pub/apache/tomcat/tomcat-8/v8.0.41/bin/apache-tomcat-8.0.41.zip
unzip apache-tomcat-8.0.41.zip
chmod u+x apache-tomcat-8.0.41/bin/*.sh

wget https://repo1.maven.org/maven2/io/gatling/highcharts/gatling-charts-highcharts-bundle/2.2.3/gatling-charts-highcharts-bundle-2.2.3-bundle.zip
unzip gatling-charts-highcharts-bundle-2.2.3-bundle.zip

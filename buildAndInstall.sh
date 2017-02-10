#!/bin/bash


cp spring-mvc-jersey-test/src/test/gatling/TestDummyJersey.scala tools/gatling-charts-highcharts-bundle-2.2.3/user-files/simulations/computerdatabase

cd spring-mvc-jersey-test/
mvn clean package
cp -r target/spring-mvc-jersey-test-0.0.1-SNAPSHOT.war ../tools/apache-tomcat-8.0.41/webapps/

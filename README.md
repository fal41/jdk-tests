Java micro benchmarks
=====================
go to ```jmh-jdk-test```

run ```mvn clean install```
run ```java -jar target/benchmarks.jar```

spring-mvc-jersey-test
======================
run ```mvn clean install```
deploy ```target/spring-mvc-jersey-test-0.0.1-SNAPSHOT.war``` to Tomcat 8
run ```src/test/gatling/TestDummyJersey``` test in gatling tool to generate load

Pre-requisites
=====================
Install OpenJDK and IBM Java for comparison
Install latest Maven 3

Java micro benchmarks
=====================
Go to ```jmh-jdk-test```

Run ```mvn clean install```

Run ```java -jar target/benchmarks.jar```

spring-mvc-jersey-test
======================

Run:

```fetchTools.sh``` to download required tools

```buildAndInstall.sh``` to build example application and copy gatling test to the gatling tool

```startTomcat.sh``` to start tomcat 8

```startGatling.sh``` to start gatling tool that generates load. Run simulation: TestDummyJersey

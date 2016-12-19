Java micro benchmarks
=====================
Go to ```jmh-jdk-test```

Run ```mvn clean install```

Run ```java -jar target/benchmarks.jar```

spring-mvc-jersey-test
======================
Run ```mvn clean install```

Deploy ```target/spring-mvc-jersey-test-0.0.1-SNAPSHOT.war``` to Tomcat 8

Run ```src/test/gatling/TestDummyJersey``` test in gatling tool to generate load

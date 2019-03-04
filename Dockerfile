FROM openjdk:13-alpine

COPY target/calculator-1.0-SNAPSHOT-test-jar-with-dependencies.jar .

CMD ["java", "-jar", "calculator-1.0-SNAPSHOT-test-jar-with-dependencies.jar"]



FROM openjdk:8-jdk-alpine
WORKDIR /proj
COPY mvnw /proj/mvnw
COPY .mvn /proj/.mvn
COPY pom.xml /proj/pom.xml
COPY src /proj/src
RUN chmod +x ./mvnw && ./mvnw clean  package spring-boot:repackage
WORKDIR /opt
ADD target/sec-demo-0.0.1-SNAPSHOT.jar /opt/sec-demo-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/opt/sec-demo-0.0.1-SNAPSHOT.jar"]

FROM hypriot/rpi-java
ADD sec-demo-0.0.1-SNAPSHOT.jar /opt/sec-demo-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/opt/sec-demo-0.0.1-SNAPSHOT.jar"]
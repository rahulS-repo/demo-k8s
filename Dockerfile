FROM openjdk:17
COPY target/demo-k8s.jar demo-k8s.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar","/demo-k8s.jar"]
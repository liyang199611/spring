FROM daocloud.io/java:8
COPY springboot-demo-1.0-SNAPSHOT.jar app.jar
EXPOSE 8082
ENTRYPOINT ["java","-jar","/app.jar","--spring.profiles.active=prod"]
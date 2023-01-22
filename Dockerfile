FROM openjdk:latest
COPY  post-service-0.0.1-SNAPSHOT.jar post_service.jar
CMD ["java","-jar","/post_service.jar"]
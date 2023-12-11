FROM openjdk:17
EXPOSE 8082
COPY build/libs/*.jar post-service.jar
ENTRYPOINT ["java","-jar","/post-service.jar"]
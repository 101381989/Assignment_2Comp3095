FROM openjdk:17
EXPOSE 8084
COPY build/libs/*.jar friendship-service.jar
ENTRYPOINT ["java","-jar","/friendship-service.jar"]
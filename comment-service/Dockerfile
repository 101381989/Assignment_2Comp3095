FROM openjdk:17
EXPOSE 8083
COPY build/libs/*.jar comment-service.jar
ENTRYPOINT ["java","-jar","/comment-service.jar"]
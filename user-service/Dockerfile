FROM openjdk:17
EXPOSE 8081
COPY build/libs/*.jar 'user-service-0.0.1-SNAPSHOT.jar'
ENTRYPOINT ["java","-jar","/user-service-0.0.1-SNAPSHOT.jar"]
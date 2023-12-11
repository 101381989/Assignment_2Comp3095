FROM openjdk:17
EXPOSE 9000
COPY build/libs/*.jar app.jar
#ENTRYPOINT ["java","-cp","-jar","/api-gateway-0.0.1-SNAPSHOT.jar","APIGateway.ApiGatewayApplication"]
ENTRYPOINT ["java","-jar","/app.jar"]
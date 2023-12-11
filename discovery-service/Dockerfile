FROM openjdk:17
EXPOSE 8761
COPY build/libs/*.jar discovery-service.jar
ENTRYPOINT ["java","-jar","/discovery-service.jar"]

#FROM eclipse-temurin:17.0.4.1_1-jre as builder
#WORKDIR /extracted
#ADD build/libs/*.jar app.jar
#RUN java -Djarmode=layertools -jar app.jar extract
#
#FROM eclipse-temurin:17.0.4.1_1-jre
#WORKDIR application
#COPY --from=builder extracted/dependencies/ ./
#COPY --from=builder extracted/spring-boot-loader/ ./
#COPY --from=builder extracted/snapshot-dependencies/ ./
#COPY --from=builder extracted/application/ ./
#EXPOSE 8080
#ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]
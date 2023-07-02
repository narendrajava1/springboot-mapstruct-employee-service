FROM eclipse-temurin:17
LABEL mentainer="Narendra Kumar Kolli"
# cd /opt/app
WORKDIR /opt/employee_service
# Refer to Maven build -> finalName
COPY target/employee-service-0.0.1-SNAPSHOT.jar /opt/employee_service/employee-service.jar 
ARG JAR_FILE=target/employee-service-0.0.1-SNAPSHOT.jar
# cp target/spring-boot-web.jar /opt/app/app.jar
COPY ${JAR_FILE} employee-service.jar
# java -jar /opt/app/app.jar
ENTRYPOINT ["java","-jar","employee-service.jar"]


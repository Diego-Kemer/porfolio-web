FROM amazoncorretto:17-alpine-jdk
MAINTAINER Diego
COPY target/porfolio-0.0.1-SNAPSHOT.jar porfolio-app.jar
ENTRYPOINT ["java","-jar","/porfolio-app.jar"]
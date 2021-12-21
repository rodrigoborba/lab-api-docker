FROM maven:3.6.1-jdk-11-slim AS build-stage

RUN mkdir -p /usr/src/app

WORKDIR /usr/src/app

ADD . /usr/src/app/

RUN mvn install 	

FROM openjdk:8 AS production-stage


COPY --from=build-stage /usr/src/app/target/test-api*.jar test-api.jar 

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "/test-api.jar"]
FROM openjdk:11-jre-slim

## Definition of user & group
ARG user=jfdelolmo
ARG group=jfdelolmo
ARG uid=1000
ARG gid=1000

## Create the user & group & association
RUN groupadd -g ${gid} ${group} && useradd -u ${uid} -g ${group} -s /bin/sh ${user}

## Define the application jar
#ARG JAR_FILE=./build/libs/*.jar
ARG JAR_FILE=./*.jar
COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java","-jar","/app.jar"]

## Switch to the user
USER ${user}
FROM maven:3.8.5-jdk-11

COPY ./App /project

WORKDIR /project

RUN mvn install

RUN mvn package

RUN ls -al



# FROM openjdk:11

# RUN java -jar compilado
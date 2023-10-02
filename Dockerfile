#
# Build stage
#
FROM maven:3.8.5-openjdk-17 AS build

WORKDIR var/movieweb
COPY . .

RUN mvn clean install

CMD mvn spring-boot:run

#RUN mvn -f /home/app/pom.xml clean package

EXPOSE 8080


#ENTRYPOINT ["java","-jar","/home/app/target/MovieWEB-0.0.1-SNAPSHOT.jar"]
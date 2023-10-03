#
# Build stage
#
FROM maven:3.8.5-openjdk-17 AS build

WORKDIR /app
COPY . .
COPY target/MovieWEB-0.0.1-SNAPSHOT.jar /app/MovieWEB-0.0.1-SNAPSHOT.jar

EXPOSE 8080

CMD ["java", "-jar", "MovieWEB-0.0.1-SNAPSHOT.jar"]


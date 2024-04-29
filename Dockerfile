FROM maven:3.8.6-openjdk-18 AS build

WORKDIR /app

COPY . .

RUN mvn clean package -U -DskipTests

FROM openjdk:17

WORKDIR /app

COPY --from=build /app/target/rnt-parametros-1.0.0.jar /app/rnt-parametros-1.0.0.jar

EXPOSE 8083

CMD ["java", "-jar", "rnt-parametros-1.0.0.jar"]
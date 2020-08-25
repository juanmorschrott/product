FROM openjdk:8-alpine

RUN apk add maven

WORKDIR /product

COPY . .

RUN mvn clean install

EXPOSE 8080

ENTRYPOINT ["mvn", "spring-boot:run"]
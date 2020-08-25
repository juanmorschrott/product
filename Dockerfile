FROM maven as builder
COPY . /usr/src/app
WORKDIR /usr/src/app
RUN mvn clean package

FROM openjdk:8-alpine
COPY --from=builder /usr/src/app/target/*.jar /app/kairosds-app.jar
WORKDIR /app
CMD ["java", "-jar", "kairosds-app.jar"]

RUN groupadd -r kairosds && useradd --no-log-init -r -g kairosds kairosds
USER kairosds

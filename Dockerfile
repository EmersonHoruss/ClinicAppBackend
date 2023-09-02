FROM eclipse-temurin:8-jdk-jammy

WORKDIR clinic-app

COPY ./.mvn .mvn
COPY src src
COPY mvnw pom.xml ./

RUN ls -a
WORKDIR .mvn
RUN ls -a

RUN ./mvnw dependency:resolve
RUN ./mvnw compile package -DskipTests

ENTRYPOINT ["./mvnw", "spring-boot:run", "-Pproduction", "-DskipTests"]

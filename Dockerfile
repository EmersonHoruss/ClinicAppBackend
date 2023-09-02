FROM eclipse-temurin:8-jdk-jammy

WORKDIR clinic-app

COPY ./.mvn .mvn
COPY src src
COPY mvnw pom.xml ./

RUN ls -a
RUN cd .mvn
RUN ls -a
g

RUN ./mvnw dependency:resolve
RUN ./mvnw compile package -DskipTests

ENTRYPOINT ["./mvnw", "spring-boot:run", "-Pproduction", "-DskipTests"]

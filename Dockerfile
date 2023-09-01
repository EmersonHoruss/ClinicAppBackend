FROM eclipse-temurin:8-jdk-jammy

WORKDIR /app

COPY .mvn .mvn
COPY pom.xml pom.xml

COPY src src

RUN mvn clean install


#COPY .mvn/ .mvn
#COPY mvnw pom.xml ./
#RUN ./mvnw dependency:resolve

#COPY src ./src

#CMD ["./mvnw", "spring-boot:run"]

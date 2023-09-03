FROM eclipse-temurin:8-jdk-jammy

WORKDIR clinic-app

RUN apt-get install dos2unix

COPY .mvn .mvn
COPY src src
COPY mvnw pom.xml ./

#RUN ls -a
#WORKDIR .mvn/wrapper
#RUN ls -a

RUN dos2unix mvnw dependency:resolve
#RUN ./mvnw compile package -DskipTests

#ENTRYPOINT ["./mvnw", "spring-boot:run", "-Pproduction", "-DskipTests"]

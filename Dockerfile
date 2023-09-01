FROM eclipse-temurin:8-jdk-jammy
VOLUME /tmp
ARG JAR_FILE
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]


#FROM eclipse-temurin:8-jdk-jammy

#WORKDIR /app

#COPY .mvn .mvn
#COPY pom.xml pom.xml
#COPY mvnw mvnw

#RUN mvnw dependency:resolve

#COPY src src

#RUN mvn clean compile install -Plocal -DskiptTests






#COPY .mvn/ .mvn
#COPY mvnw pom.xml ./
#RUN ./mvnw dependency:resolve

#COPY src ./src

#CMD ["./mvnw", "spring-boot:run"]

FROM bellsoft/liberica-runtime-container:jdk-17-musl AS builder
WORKDIR /app
COPY pom.xml mvnw ./
COPY .mvn .mvn
RUN ./mvnw dependency:go-offline
COPY src src
RUN ./mvnw clean package -DskipTests

# Runtime stage (Minimal JRE image)
FROM bellsoft/liberica-runtime-container:jre-17-musl
WORKDIR /app
COPY --from=builder /app/target/devops-prac-spring1-0.0.1-SNAPSHOT.jar devops-prac-spring1-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "devops-prac-spring1-0.0.1-SNAPSHOT.jar"]
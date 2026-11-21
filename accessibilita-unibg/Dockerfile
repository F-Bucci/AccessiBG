# Fase 1: Build con Maven e Java 17 nell'ordine esatto delle dipendenze
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .

# 1. Prima il Backend (non ha dipendenze interne)
RUN mvn -f AccessiBG_Backend/pom.xml clean install -DskipTests

# 2. Poi SQLite (dipende da AccessiBG_Backend)
RUN mvn -f AccessiBG_sqlite/pom.xml clean install -DskipTests

# 3. Infine la UI Vaadin in modalità production (dipende da entrambi)
# (Se il pom.xml della UI sta nella root invece che in accessibilita-unibg/, togli "-f accessibilita-unibg/pom.xml")
RUN mvn -f accessibilita-unibg/pom.xml clean package -Pproduction -DskipTests

# Fase 2: Esecuzione su Ubuntu jammy (compatibile con la libreria nativa di sqlite-jdbc)
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app

# (Togli "accessibilita-unibg/" dal percorso se il pom.xml UI è nella root)
COPY --from=build /app/accessibilita-unibg/target/*-SNAPSHOT.jar /app/app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-Xmx380m", "-jar", "/app/app.jar", "--spring.profiles.active=prod"]
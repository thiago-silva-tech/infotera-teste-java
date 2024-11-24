# Etapa 1: Base para construir o projeto
FROM maven:3.9.5-eclipse-temurin-17 AS build-stage

# Definir diretório de trabalho para o build
WORKDIR /app

# Copiar arquivos do projeto para o container
COPY pom.xml .
COPY src ./src

# Fazer o build do projeto
RUN mvn clean package

# Etapa 2: Base para rodar a aplicação (WildFly)
FROM bitnami/wildfly:21.0.2

#ENV WILDFLY_USER=admin
#ENV WILDFLY_PASSWORD=admin123

# Copiar o WAR gerado para o diretório de deployments do WildFly
COPY --from=build-stage /app/target/infotera-teste-java.war /opt/bitnami/wildfly/standalone/deployments/

# Expor a porta padrão do WildFly
EXPOSE 8080
EXPOSE 9990
# Comando de inicialização do WildFly
CMD ["/opt/bitnami/wildfly/bin/standalone.sh", "-b", "0.0.0.0"]
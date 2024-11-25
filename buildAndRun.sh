#!/bin/sh
mvn clean package && docker build -t infotera-teste-java .
docker rm -f infotera-teste-java || true && docker run -d -p 8080:8080 -p 9990:9990 --name infotera-teste-java-wildfly-server infotera-teste-java
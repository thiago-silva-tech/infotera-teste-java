@echo off
call mvn clean package
call docker build -t infotera-teste-java .
call docker rm -f infotera-teste-java-wildfly-server
call docker run -d -p 8080:8080 -p 9990:9990 --name infotera-teste-java-wildfly-server infotera-teste-java
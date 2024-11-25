# INFOTERA - TESTE JAVA
## Autor: Thiago H. da Silva

### Ferramentas utilizadas
- JDK 11
- Java EE 8
- Wildfly 21
- JPA 2.2 (implementação: Hibernate 6.1.5)
- JSF 2.3 (implementação: Mojarra 2.3.14)
- Primefaces 8
- Maven
- H2 Database

### Prérequisitos
- JDK 11+
- Maven
- Wildfly 21 ou Docker

### Como executar o projeto
Existem 3 formas diferentes de rodar o projeto

- **Opção 1: instalação de manual do Wildfly**
	- se você preferir rodar o Wildfly manualmente, basta iniciar o servidor e copiar o arquivo **infotera-teste-java.war**, que está na pasta raiz do projeto, ou buildar o arquivo .war com o Maven você mesmo com o comando mvn package, e colar o arquivo .war na pasta **[pasta_instalação_wildfly]/standalone/deployments** da sua instalação, e acessar **http://localhost:8080/infotera-teste-java/**

- **Opção 2: instalação via IDE**
	- se você tem o Wildfly já instalado na sua IDE basta importar o projeto e adiciona-lo no servidor, iniciar o servidor e acessar **http://localhost:8080/infotera-teste-java/**
	
- **Opção 3: com docker**
	- se você possui a Docker instalado na sua máquina basta rodar o script **buildAndRun.sh** (para Linux) ou **buildAndRun.bat** (para Windows), o script irá buildar a imagem e inicializar o servidor Wildfly em um container, depois é só acessar **http://localhost:8080/infotera-teste-java/**



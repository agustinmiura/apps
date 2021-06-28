# Unit testing

- Spring boot 2 api with unit testing and mockito

- Install
    - Docker .
    - Jdk 11 .

# Getting Started
- Setup the `application.properties` according to the `application.properties.sample`
- Run the command `mvn clean compile` to compile .
- Run the command `mvn clean test` to run test .

#Accesing H2 database 

- Go to the url `http://localhost:8080/h2-console/login.do`
- See the content

#Content for the application properties file 

```
spring.jpa.show-sql=true
spring.h2.console.enabled=true
spring.datasource.url=jdbc:h2:mem:testdb
spring.data.jpa.repositories.bootstrap-mode=default
```

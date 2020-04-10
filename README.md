# Travel Api Example

## Stack
- Java 11
- Spring 
- Springboot
- Spring Data JPA
- Flyway migration
- Lombok

- Postgres

## Table Relationship

![Tables](https://github.com/rodrigorpo/java-springboot-travel/blob/master/src/main/resources/relation.png)

## How to run

### Configure envriomment

``
  docker-compose up
``

### Configure properties
- File application.properties

```
  spring.datasource.url=jdbc:postgresql://192.168.99.100:5432/travel?currentSchema=travel
  spring.datasource.username=admin
  spring.datasource.password=pass
```

- Option 1:
   - Run application using IDE

- Option 2:
   - Run application with jar generated

``
  mvn clean install -DskipTests
  java -jar target/travel-0.0.1-SNAPSHOT.jar
``

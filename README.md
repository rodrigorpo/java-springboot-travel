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



## How to run

### Configure envriomment

``sh
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

``sh
  mvn clean install -DskipTests
  java -jar target/travel-0.0.1-SNAPSHOT.jar
``

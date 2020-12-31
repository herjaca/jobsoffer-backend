#JOBS OFFER

#Koltin - Spring-Boot

**run**

`mvn spring-boot:run` 

**use**
1. kotlin 1.4.10
2. Spring Boot 2.4.0
3. JPA
4. PostgresSQL 11

#Data Base Configuration

**You need to have Postgres 11 installed.**

#Create User and Database

**To work with the current configuration of the property file.**

```
postgres=# create database jobs;
postgres=# create user donestreet with encrypted password 'donestreet';
postgres=# grant all privileges on database jobs to donestreet;
```

**Or you can update the properties files**

```
#DATABASE
spring.datasource.url=jdbc:postgresql://localhost/jobs
spring.datasource.username=donestreet
spring.datasource.password=donestreet
spring.jpa.generate-ddl=true
```

**With your personalized configuration.
  Remember to update the connection url, as well as the username and password data.**

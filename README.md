# Clevertec final project


##  Technology stack:
**`Spring Boot (Web, Data JPA, Validation, Security)`**, **`PostgreSQL`**, **`Liquibase`**, **`Docker`**, **`Gradle`**, **`Redis`**. 


## How to build
1. Build project: gradle clean build
2. To run environment: docker compose up

##  Endpoints:

### News service:

|   HTTP Method   | URL                                                          | Description                       |
|:---------------:|--------------------------------------------------------------|-----------------------------------|
|      `GET`      | localhost/api/v1/news/{uuid}                                 | Get all news                      |
|      `GET`      | localhost/api/v1/news                                        | Get by UUID                       |
|      `GET`      | localhost/api/v1/news/overview/{uuid}                        | Get with comments by UUID         |
|      `DELETE`   | localhost/api/v1/news/{UUID}                                 | Delete news.                      |
|      `PUT`      | localhost/api/v1/news/{UUID}                                 | Update news                       |
|      `POST`     | localhost/api/v1/news                                        | Create news                       |
|:---------------:|--------------------------------------------------------------|-----------------------------------|
|      `GET`      | localhost/api/v1/comments/{uuid}                             | Get all comments                  |
|      `GET`      | localhost/api/v1/comments/                                   | Get by UUID                       |
|      `DELETE`   | localhost/api/v1/comments/{UUID}                             | Get all comments                  |
|      `PUT`      | localhost/api/v1/comments/{UUID}                             | Update news                       |
|      `POST`     | localhost/api/v1/comments                                    | Create news                       |

### User service:

|   HTTP Method   | URL                                                          | Description                       |
|:---------------:|--------------------------------------------------------------|-----------------------------------|
|      `GET`      | localhost/api/v1/users/{uuid}                                 | Get all users                    |
|      `GET`      | localhost/api/v1/users                                        | Get by UUID                      |
|      `DELETE`   | localhost/api/v1/users/{UUID}                                 | Delete users                     |
|      `PUT`      | localhost/api/v1/users/{UUID}                                 | Update users                     |
|      `POST`     | localhost/api/v1/users                                        | Create users                     |
|      `POST`     | localhost/api/v1/users/login                                  | Authenticate user                |
|      `POST`     | localhost/api/v1/users/registration                           | Registrate users                 |
|      `GET`      | localhost/api/v1/users/me                                     | Get Information                  |


### DB

### News service:
```postgresql
    CREATE SCHEMA IF NOT EXISTS zerkalo;

    CREATE TABLE IF NOT EXISTS zerkalo.news
    (
    uuid         uuid not null primary key,
    created_date timestamp(6) with time zone,
    updated_date timestamp(6) with time zone,
    text         varchar(255),
    title        varchar(255),
    username     varchar(255),
    modified_by  varchar(255)
    );
    
    CREATE TABLE IF NOT EXISTS zerkalo.comments
    (
    uuid         uuid not null primary key,
    created_date timestamp(6) with time zone,
    updated_date timestamp(6) with time zone,
    text         varchar(255),
    username     varchar(255),
    modified_by  varchar(255),
    news_uuid    uuid
        constraint fkf2nsws3lfsxl5sxrgq7lw60q8
            references news
    );
```
### User service:

```postgresql
    
    CREATE TABLE IF NOT EXISTS users
    (
    uuid        uuid not null
        primary key,
    create_date timestamp(3) with time zone,
    update_date timestamp(3) with time zone,
    mail        varchar(255)
        constraint emailconstraint unique,
    nick        varchar(255)
        constraint nickconstraint unique,
    password    varchar(255),
    role        varchar(128),
    status      varchar(255)
    );
    
   
```

--liquibase formatted sql

--changeset grisha:1
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";


--changeset grisha:2
create schema if not exists zerkalo;

--changeset grisha:3
create table if not exists zerkalo.news
(
    uuid uuid not null primary key,
    created_date timestamp(6) with time zone,
    updated_date timestamp(6) with time zone,
    text varchar(255),
    title varchar(255),
    username varchar(255),
    modified_by varchar(255)

);
--changeset grisha:4
create table if not exists zerkalo.comments
(
    uuid uuid not null primary key,
    created_date timestamp(6) with time zone,
    updated_date timestamp(6) with time zone,
    text         varchar(255),
    username     varchar(255),
    modified_by varchar(255),
    news_uuid    uuid
    constraint fkf2nsws3lfsxl5sxrgq7lw60q8 references zerkalo.news
);







--liquibase formatted sql


--changeset grisha:1
CREATE SCHEMA IF NOT EXISTS signed;

--changeset grisha:2
CREATE TABLE IF NOT EXISTS signed.users
(
    uuid uuid NOT NULL,
    create_date timestamp(3) with time zone,
    update_date timestamp(3) with time zone,
    mail character varying(255),
    nick character varying(255),
    password character varying(255),
    role character varying(128),
    status character varying(255),
    CONSTRAINT users_pkey PRIMARY KEY (uuid),
    CONSTRAINT emailconstraint UNIQUE (mail),
    CONSTRAINT nickconstraint UNIQUE (nick)
);






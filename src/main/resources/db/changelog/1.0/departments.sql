--liquibase formatted sql
--changeset Andr33w:itk-project-spring-data-002
--logicalFilePath:1.0/departments.sql

CREATE TABLE IF NOT EXISTS departments (

    id          UUID            PRIMARY KEY DEFAULT uuid_generate_v4(),
    name        TEXT            NOT NULL
);

--rollback DROP TABLE IF EXISTS departments;
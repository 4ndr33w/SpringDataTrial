--liquibase formatted sql
--changeset Andr33w:itk-project-spring-data-005
--logicalFilePath:2.0/update-employee-emails.sql

UPDATE employees
SET email = id::text || '@123.ru'
WHERE email IS NULL OR TRIM(email) = '';
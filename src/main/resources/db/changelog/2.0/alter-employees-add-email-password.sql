--liquibase formatted sql
--changeset Andr33w:itk-project-spring-data-004
--logicalFilePath:2.0/alter-employees-add-email-password.sql

ALTER TABLE employees
ADD COLUMN IF NOT EXISTS email TEXT;

ALTER TABLE employees
ADD COLUMN IF NOT EXISTS password TEXT;

--rollback ALTER TABLE employees DROP COLUMN IF EXISTS password;
--rollback ALTER TABLE employees DROP COLUMN IF EXISTS email;
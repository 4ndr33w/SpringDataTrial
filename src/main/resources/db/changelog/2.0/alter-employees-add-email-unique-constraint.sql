--liquibase formatted sql
--changeset Andr33w:itk-project-spring-data-006
--logicalFilePath:2.0/alter-employees-add-email-unique-constraint.sql

ALTER TABLE employees
ADD CONSTRAINT unique_employee_email UNIQUE (email);

--rollback ALTER TABLE employees DROP CONSTRAINT IF EXISTS unique_employee_email;
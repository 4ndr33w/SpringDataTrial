--liquibase formatted sql
--changeset Andr33w:itk-project-spring-data-003
--logicalFilePath:1.0/employees.sql

CREATE TABLE IF NOT EXISTS employees (
    id              UUID            PRIMARY KEY DEFAULT uuid_generate_v4(),
    first_name      TEXT            NOT NULL,
    last_name       TEXT            NOT NULL,
    position        TEXT            NOT NULL,
    salary          DECIMAL(10, 2)  NOT NULL,
    department_id   UUID,

    CONSTRAINT fk_employee_department
        FOREIGN KEY (department_id)
        REFERENCES departments (id)
        ON DELETE SET NULL
);

--rollback DROP TABLE IF EXISTS employees;


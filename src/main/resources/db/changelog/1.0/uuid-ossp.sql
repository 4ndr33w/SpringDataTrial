--liquibase formatted sql
--changeset Andr33w:itk-project-spring-data-001
--logicalFilePath:1.0/uuid-ossp.sql

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

--rollback drop extension uuid-ossp;
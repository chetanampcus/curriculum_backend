CREATE TABLE roles (
    role_id BIGINT PRIMARY KEY,
    role_name VARCHAR(100) NOT NULL UNIQUE,
    description TEXT
);

INSERT INTO roles (role_id, role_name, description) VALUES
(100000, 'ROLE_HIGHSCOPE_ADMIN', 'HighScope Administrator'),
(100001, 'ROLE_ORG_ACCOUNT_MANAGER', 'Organization Account Manager'),
(100002, 'ROLE_SITE_ACCOUNT_MANAGER', 'Site Account Manager'),
(100004, 'ROLE_TEACHER', 'Teacher Role'),
(100005, 'ROLE_VIEWER', 'Viewer Role');

-- Remove ROLE_SITE_ACCOUNT_MANAGER
DELETE FROM roles WHERE role_id = 100002;

-- Remove old ROLE_ORG_ACCOUNT_MANAGER to avoid UNIQUE constraint violation
DELETE FROM roles WHERE role_id = 100001;

-- Insert 100002 as ROLE_ORG_ACCOUNT_MANAGER
INSERT INTO roles (role_id, role_name, description)
VALUES (100002, 'ROLE_ORG_ACCOUNT_MANAGER', 'Organization Account Manager');

-- Insert 100001 as INTERNAL_ASSESSOR
INSERT INTO roles (role_id, role_name, description)
VALUES (100001, 'ROLE_INTERNAL_ASSESSOR', 'Internal Assessor');

-- Update role_id 100005 to EXTERNAL_ASSESSOR
UPDATE roles
SET role_name = 'ROLE_EXTERNAL_ASSESSOR', description = 'External Assessor'
WHERE role_id = 100005;
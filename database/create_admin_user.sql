-- Create Admin User
-- Email: Admin@eventapp.fr
-- Password: pass123
-- BCrypt hash of "pass123" with strength 10

INSERT INTO users (name, email, password, location_id, role, created_at)
VALUES (
    'Admin',
    'Admin@eventapp.fr',
    '$2a$10$N9qo8uLOickgx2ZMRZoMye1lXzWNsHILHNLOIJXJo3qLlLWBKYCdC',
    1,
    'ADMIN',
    NOW()
)
ON DUPLICATE KEY UPDATE
    password = '$2a$10$N9qo8uLOickgx2ZMRZoMye1lXzWNsHILHNLOIJXJo3qLlLWBKYCdC',
    role = 'ADMIN',
    name = 'Admin';

-- Verify the admin user was created
SELECT id, name, email, role, created_at FROM users WHERE email = 'Admin@eventapp.fr';

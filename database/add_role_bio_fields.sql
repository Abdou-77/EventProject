-- Add role and bio fields to users table
-- Run this script after starting Docker containers

USE eventdb;

-- Add role column if it doesn't exist
ALTER TABLE users 
ADD COLUMN IF NOT EXISTS role VARCHAR(20) DEFAULT 'USER' AFTER password;

-- Add bio column if it doesn't exist
ALTER TABLE users 
ADD COLUMN IF NOT EXISTS bio TEXT AFTER role;

-- Set first user as ADMIN for testing
UPDATE users SET role = 'ADMIN' WHERE id = 1;

-- Show updated table structure
DESCRIBE users;

-- Show all users with their roles
SELECT id, name, email, role FROM users;

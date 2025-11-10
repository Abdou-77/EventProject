#!/bin/bash

# Script to fix and restart the EventProject after adding role and bio fields
# Run this script after Docker Desktop is started

echo "🚀 Starting EventProject setup..."

# Stop all containers
echo "📦 Stopping containers..."
docker-compose down

# Add role and bio columns to database
echo "🗄️  Updating database schema..."
docker-compose up -d db
sleep 5

# Apply database schema changes
docker-compose exec -T db mysql -uroot -prootpassword eventdb < database/add_role_bio_fields.sql

# Rebuild backend with new User model
echo "🔨 Rebuilding backend..."
docker-compose build --no-cache backend

# Start all services
echo "🚀 Starting all services..."
docker-compose up -d

# Wait for services to be ready
echo "⏳ Waiting for services to start..."
sleep 10

# Check status
echo "✅ Checking services status..."
docker-compose ps

echo ""
echo "🎉 Setup complete!"
echo ""
echo "🌐 Access the application:"
echo "   Frontend: http://localhost:8000"
echo "   Backend:  http://localhost:8081"
echo ""
echo "👤 Test users:"
echo "   Admin:    sophie.martin@email.fr (password: password123)"
echo "   Regular:  Create a new account with the signup form"
echo ""
echo "✨ New features:"
echo "   - Profile page: http://localhost:8000/profile"
echo "   - Favorites page: http://localhost:8000/favorites"
echo "   - Add to favorites: Heart icon on event cards (when logged in)"
echo "   - Admin only: 'Créer un événement' visible only for admin users"

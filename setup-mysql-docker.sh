#!/bin/bash

# Quick MySQL Setup using Docker
# This script sets up MySQL in Docker for EventApp

echo "🐳 EventApp - MySQL Docker Setup"
echo "=================================="
echo ""

# Check if Docker is installed
if ! command -v docker &> /dev/null; then
    echo "❌ Docker is not installed!"
    echo ""
    echo "Please install Docker Desktop for Mac:"
    echo "https://www.docker.com/products/docker-desktop"
    echo ""
    exit 1
fi

echo "✅ Docker is installed"
echo ""

# Check if container already exists
if docker ps -a --format '{{.Names}}' | grep -q "^mysql-eventdb$"; then
    echo "📦 Container 'mysql-eventdb' already exists"
    
    # Check if it's running
    if docker ps --format '{{.Names}}' | grep -q "^mysql-eventdb$"; then
        echo "✅ MySQL is already running!"
    else
        echo "🚀 Starting existing MySQL container..."
        docker start mysql-eventdb
        echo "✅ MySQL started!"
    fi
else
    echo "📦 Creating new MySQL container..."
    docker run --name mysql-eventdb \
        -e MYSQL_ROOT_PASSWORD=root \
        -e MYSQL_DATABASE=eventdb \
        -p 3306:3306 \
        -d mysql:8.0
    
    echo "⏳ Waiting for MySQL to be ready..."
    sleep 10
    echo "✅ MySQL container created and started!"
fi

echo ""
echo "=================================="
echo "🎉 MySQL is ready!"
echo "=================================="
echo ""
echo "Connection Details:"
echo "  Host: localhost"
echo "  Port: 3306"
echo "  Database: eventdb"
echo "  Username: root"
echo "  Password: root"
echo ""
echo "Update your application.properties if needed:"
echo "  spring.datasource.password=root"
echo ""
echo "Useful Commands:"
echo "  Stop MySQL:    docker stop mysql-eventdb"
echo "  Start MySQL:   docker start mysql-eventdb"
echo "  Remove MySQL:  docker rm -f mysql-eventdb"
echo "  View logs:     docker logs mysql-eventdb"
echo ""
echo "You can now start the backend!"
echo "=================================="

#!/bin/bash

# Script de démarrage rapide pour tester le DataSeeder

echo "=================================="
echo "🚀 Starting Event Management System"
echo "=================================="
echo ""

cd /Users/abdallahsofi/Downloads/EventProject/back-end

echo "📦 Cleaning and compiling..."
mvn clean compile -q

if [ $? -eq 0 ]; then
    echo "✅ Compilation successful!"
    echo ""
    echo "🌱 Starting Spring Boot application..."
    echo "   The database will be populated automatically!"
    echo ""
    echo "📡 API will be available at: http://localhost:8080"
    echo ""
    echo "Test endpoints:"
    echo "  - http://localhost:8080/api/events"
    echo "  - http://localhost:8080/api/categories"
    echo "  - http://localhost:8080/api/locations"
    echo ""
    echo "Press Ctrl+C to stop the server"
    echo "=================================="
    echo ""

    mvn spring-boot:run
else
    echo "❌ Compilation failed!"
    exit 1
fi


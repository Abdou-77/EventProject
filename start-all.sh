#!/bin/bash

# Master startup script for EventApp
# Starts both backend and frontend

echo "🚀 EventApp - Complete Startup"
echo "=================================="
echo ""

PROJECT_DIR="/Users/abdallahsofi/Downloads/EventProject"

# Function to check if port is in use
check_port() {
    lsof -i :$1 &> /dev/null
    return $?
}

# Check MySQL
echo "1️⃣ Checking MySQL..."
if ! lsof -i :3306 &> /dev/null; then
    echo "❌ MySQL is not running on port 3306"
    echo ""
    echo "Please start MySQL first:"
    echo "  - Using Docker: ./setup-mysql-docker.sh"
    echo "  - Using Homebrew: brew services start mysql"
    echo "  - Or check SETUP_GUIDE.md for other options"
    echo ""
    exit 1
fi
echo "✅ MySQL is running"
echo ""

# Check backend port
echo "2️⃣ Checking Backend port (8080)..."
if check_port 8080; then
    echo "⚠️  Port 8080 is already in use"
    read -p "Kill existing process? (y/n) " -n 1 -r
    echo ""
    if [[ $REPLY =~ ^[Yy]$ ]]; then
        lsof -ti :8080 | xargs kill -9
        echo "✅ Port 8080 freed"
    else
        exit 1
    fi
else
    echo "✅ Port 8080 is available"
fi
echo ""

# Check frontend port
echo "3️⃣ Checking Frontend port (4200)..."
if check_port 4200; then
    echo "⚠️  Port 4200 is already in use"
    read -p "Kill existing process? (y/n) " -n 1 -r
    echo ""
    if [[ $REPLY =~ ^[Yy]$ ]]; then
        lsof -ti :4200 | xargs kill -9
        echo "✅ Port 4200 freed"
    else
        exit 1
    fi
else
    echo "✅ Port 4200 is available"
fi
echo ""

# Start Backend
echo "4️⃣ Starting Backend..."
echo "=================================="
cd "$PROJECT_DIR/back-end"

# Check if mvnw is executable
if [ ! -x "./mvnw" ]; then
    chmod +x ./mvnw
fi

echo "📦 Compiling backend..."
./mvnw clean compile -q

if [ $? -ne 0 ]; then
    echo "❌ Backend compilation failed!"
    exit 1
fi

echo "✅ Backend compiled successfully"
echo "🚀 Starting Spring Boot application..."
echo ""

# Start backend in background
./mvnw spring-boot:run > /tmp/eventapp-backend.log 2>&1 &
BACKEND_PID=$!

echo "Backend PID: $BACKEND_PID"
echo "Backend logs: /tmp/eventapp-backend.log"
echo ""
echo "⏳ Waiting for backend to start (this may take 30-60 seconds)..."

# Wait for backend to be ready
MAX_WAIT=60
WAITED=0
while [ $WAITED -lt $MAX_WAIT ]; do
    if curl -s http://localhost:8080/api/events > /dev/null 2>&1; then
        echo "✅ Backend is ready!"
        break
    fi
    sleep 2
    WAITED=$((WAITED + 2))
    echo -n "."
done
echo ""

if [ $WAITED -ge $MAX_WAIT ]; then
    echo "⚠️  Backend taking longer than expected..."
    echo "Check logs: tail -f /tmp/eventapp-backend.log"
    echo ""
fi

# Start Frontend
echo ""
echo "5️⃣ Starting Frontend..."
echo "=================================="
cd "$PROJECT_DIR/front-end"

# Check if node_modules exists
if [ ! -d "node_modules" ]; then
    echo "📦 Installing frontend dependencies..."
    npm install
    echo ""
fi

echo "🌐 Starting Angular development server..."
echo ""

# Start frontend
ng serve --open > /tmp/eventapp-frontend.log 2>&1 &
FRONTEND_PID=$!

echo "Frontend PID: $FRONTEND_PID"
echo "Frontend logs: /tmp/eventapp-frontend.log"
echo ""

# Save PIDs to file for easy cleanup
echo "$BACKEND_PID" > /tmp/eventapp-backend.pid
echo "$FRONTEND_PID" > /tmp/eventapp-frontend.pid

echo ""
echo "=================================="
echo "✅ EventApp is starting!"
echo "=================================="
echo ""
echo "🌐 Access your application:"
echo "   Frontend: http://localhost:4200"
echo "   Backend:  http://localhost:8080"
echo ""
echo "📊 Monitor logs:"
echo "   Backend:  tail -f /tmp/eventapp-backend.log"
echo "   Frontend: tail -f /tmp/eventapp-frontend.log"
echo ""
echo "🛑 Stop all services:"
echo "   ./stop-all.sh"
echo ""
echo "Process IDs saved to:"
echo "   Backend:  /tmp/eventapp-backend.pid"
echo "   Frontend: /tmp/eventapp-frontend.pid"
echo ""
echo "=================================="
echo "The browser should open automatically in a few seconds..."
echo "If not, visit: http://localhost:4200"
echo "=================================="

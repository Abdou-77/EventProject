#!/bin/bash

# Stop all EventApp services

echo "🛑 Stopping EventApp Services"
echo "=================================="
echo ""

# Function to stop process
stop_service() {
    local name=$1
    local pid_file=$2
    local port=$3
    
    echo "Stopping $name..."
    
    # Try to stop using PID file
    if [ -f "$pid_file" ]; then
        PID=$(cat "$pid_file")
        if ps -p $PID > /dev/null 2>&1; then
            kill $PID
            echo "  ✅ Stopped $name (PID: $PID)"
        fi
        rm -f "$pid_file"
    fi
    
    # Also check port and kill any process using it
    if lsof -ti :$port > /dev/null 2>&1; then
        lsof -ti :$port | xargs kill -9
        echo "  ✅ Freed port $port"
    fi
}

# Stop backend
stop_service "Backend" "/tmp/eventapp-backend.pid" "8080"

# Stop frontend
stop_service "Frontend" "/tmp/eventapp-frontend.pid" "4200"

# Clean up log files (optional)
if [ -f "/tmp/eventapp-backend.log" ]; then
    rm -f /tmp/eventapp-backend.log
fi
if [ -f "/tmp/eventapp-frontend.log" ]; then
    rm -f /tmp/eventapp-frontend.log
fi

echo ""
echo "=================================="
echo "✅ All services stopped!"
echo "=================================="

#!/bin/bash

# Check status of all EventApp services

echo "🔍 EventApp Status Check"
echo "=================================="
echo ""

# Check MySQL
echo "1️⃣ MySQL (Port 3306):"
if lsof -i :3306 &> /dev/null; then
    echo "   ✅ RUNNING"
    # Try to get MySQL version
    if command -v mysql &> /dev/null; then
        mysql --version 2>/dev/null | head -1
    fi
else
    echo "   ❌ NOT RUNNING"
    echo "   → Start with: ./setup-mysql-docker.sh"
fi
echo ""

# Check Backend
echo "2️⃣ Backend (Port 8080):"
if lsof -i :8080 &> /dev/null; then
    echo "   ✅ RUNNING"
    if curl -s http://localhost:8080/api/events > /dev/null 2>&1; then
        echo "   ✅ API responding"
        # Count events
        COUNT=$(curl -s http://localhost:8080/api/events | grep -o "\"id\"" | wc -l)
        echo "   📊 Events in database: $COUNT"
    else
        echo "   ⚠️  Service starting or not responding"
    fi
    
    # Show PID
    PID=$(lsof -ti :8080)
    echo "   PID: $PID"
else
    echo "   ❌ NOT RUNNING"
    echo "   → Start with: cd back-end && ./start-with-seeder.sh"
fi
echo ""

# Check Frontend
echo "3️⃣ Frontend (Port 4200):"
if lsof -i :4200 &> /dev/null; then
    echo "   ✅ RUNNING"
    if curl -s http://localhost:4200 > /dev/null 2>&1; then
        echo "   ✅ Server responding"
    else
        echo "   ⚠️  Service starting or not responding"
    fi
    
    # Show PID
    PID=$(lsof -ti :4200)
    echo "   PID: $PID"
else
    echo "   ❌ NOT RUNNING"
    echo "   → Start with: cd front-end && ./start.sh"
fi
echo ""

# System info
echo "=================================="
echo "4️⃣ System Information:"
echo "   Java: $(java -version 2>&1 | head -1)"
echo "   Node: $(node --version)"
echo "   npm:  $(npm --version)"
echo ""

# Check logs
echo "=================================="
echo "5️⃣ Recent Logs:"
if [ -f "/tmp/eventapp-backend.log" ]; then
    echo ""
    echo "Backend (last 5 lines):"
    tail -5 /tmp/eventapp-backend.log | sed 's/^/   /'
fi

if [ -f "/tmp/eventapp-frontend.log" ]; then
    echo ""
    echo "Frontend (last 5 lines):"
    tail -5 /tmp/eventapp-frontend.log | sed 's/^/   /'
fi

echo ""
echo "=================================="
echo "Quick Actions:"
echo "   Start all:  ./start-all.sh"
echo "   Stop all:   ./stop-all.sh"
echo "   This check: ./check-status.sh"
echo "=================================="

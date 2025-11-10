#!/bin/bash

# Add MySQL to PATH for this session
export PATH="/opt/homebrew/opt/mysql/bin:$PATH"

# Verify MySQL is accessible
if ! command -v mysql &> /dev/null; then
    echo "❌ MySQL not found even after adding to PATH"
    echo "Using direct path: /opt/homebrew/opt/mysql/bin/mysql"
fi

echo "✅ MySQL configured!"
echo "You can now use 'mysql' command"
echo ""
echo "To make this permanent, add to your ~/.zshrc:"
echo 'export PATH="/opt/homebrew/opt/mysql/bin:$PATH"'

@echo off
echo Restarting Backend Server...
cd backend
taskkill /F /IM node.exe 2>nul
timeout /t 2 /nobreak >nul
start cmd /k "npm start"
echo Backend server restarting...

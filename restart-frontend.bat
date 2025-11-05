@echo off
echo Restarting Frontend Server...
cd frontend
taskkill /F /IM node.exe /FI "WINDOWTITLE eq npm*" 2>nul
timeout /t 2 /nobreak >nul
start cmd /k "npm start"
echo Frontend server restarting...

@echo off
title Health Management System Starter
color 0A

echo ========================================
echo   HEALTH MANAGEMENT SYSTEM
echo   Starting Application...
echo ========================================
echo.

REM Check if MongoDB is running
echo [1/4] Checking MongoDB...
sc query MongoDB | find "RUNNING" >nul
if errorlevel 1 (
    echo MongoDB is not running. Starting MongoDB...
    net start MongoDB
    timeout /t 3 >nul
) else (
    echo MongoDB is already running!
)
echo.

REM Start Backend Server
echo [2/4] Starting Backend Server...
cd backend
start "Health Management System Backend" cmd /k "npm start"
timeout /t 5 >nul
echo.

REM Start Frontend Development Server
echo [3/4] Starting Frontend Development Server...
cd ..\frontend
start "Health Management System Frontend" cmd /k "npm start"
echo.

echo [4/4] Application Starting...
echo.
echo ========================================
echo   HEALTH MANAGEMENT SYSTEM
echo ========================================
echo.
echo Backend Server:  http://localhost:8080
echo Frontend App:    http://localhost:3000
echo.
echo The browser will open automatically.
echo.
echo Press any key to close this window...
pause >nul

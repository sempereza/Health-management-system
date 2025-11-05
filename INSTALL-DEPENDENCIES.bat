@echo off
title Health Management System - Install Dependencies
color 0B

echo ========================================
echo   HEALTH MANAGEMENT SYSTEM
echo   Installing Dependencies...
echo ========================================
echo.

REM Install Backend Dependencies
echo [1/2] Installing Backend Dependencies...
cd backend
call npm install
if errorlevel 1 (
    echo ERROR: Backend installation failed!
    pause
    exit /b 1
)
echo Backend dependencies installed successfully!
echo.

REM Install Frontend Dependencies
echo [2/2] Installing Frontend Dependencies...
cd ..\frontend
call npm install
if errorlevel 1 (
    echo ERROR: Frontend installation failed!
    pause
    exit /b 1
)
echo Frontend dependencies installed successfully!
echo.

cd ..
echo ========================================
echo   Installation Complete!
echo ========================================
echo.
echo All dependencies have been installed.
echo You can now run START-HEALTH-SYSTEM.bat
echo.
pause

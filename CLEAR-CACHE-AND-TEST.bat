@echo off
color 0A
title Theme Toggle - Cache Clear & Test

echo.
echo ========================================
echo   THEME TOGGLE - QUICK TEST
echo ========================================
echo.

echo [STEP 1] Stopping any running servers...
taskkill /F /IM node.exe 2>nul
timeout /t 2 /nobreak >nul
echo Done!

echo.
echo [STEP 2] Starting fresh server...
cd /d "%~dp0"
start "SMS Server" cmd /k "npm start"
echo Server starting... (waiting 5 seconds)
timeout /t 5 /nobreak >nul

echo.
echo ========================================
echo   CLEAR YOUR BROWSER CACHE NOW!
echo ========================================
echo.
echo Press Ctrl + Shift + Delete
echo Select: "Cached images and files"
echo Click: "Clear data"
echo.
echo OR USE INCOGNITO MODE:
echo Press: Ctrl + Shift + N
echo.
pause

echo.
echo [STEP 3] Opening test page in browser...
start http://localhost:3000/theme-test.html

echo.
echo ========================================
echo   HOW TO TEST THE THEME:
echo ========================================
echo.
echo 1. Look at the TOP-RIGHT corner
echo 2. You'll see a Moon icon (moon emoji)
echo 3. Click it
echo 4. Background turns DARK BLUE
echo 5. All text turns WHITE
echo 6. Button changes to Sun icon
echo 7. Click Sun icon
echo 8. Background turns WHITE
echo 9. Text turns DARK
echo.
echo ========================================
echo   IF NOTHING CHANGES:
echo ========================================
echo.
echo 1. Open INCOGNITO window: Ctrl+Shift+N
echo 2. Go to: localhost:3000/theme-test.html
echo 3. Click the moon button
echo 4. Theme WILL work in incognito!
echo.
echo ========================================

echo.
echo Server is running...
echo Press any key to stop the server and exit
pause >nul

echo.
echo [CLEANUP] Stopping server...
taskkill /F /IM node.exe 2>nul
echo.
echo Done! Theme test complete.
timeout /t 2 /nobreak >nul

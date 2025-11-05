@echo off
color 0F
title WHITE BACKGROUND TEST - Easy Mode

cls
echo.
echo ========================================
echo   WHITE BACKGROUND TEST
echo ========================================
echo.
echo This will test your new white background!
echo.
pause

echo.
echo [1/3] Stopping old servers...
taskkill /F /IM node.exe 2>nul
timeout /t 2 /nobreak >nul
echo Done!

echo.
echo [2/3] Starting fresh server...
cd /d "%~dp0"
start "SMS Server" cmd /k "color 0A && echo Server is running... && echo White background is ready! && npm start"
echo Waiting 5 seconds for server to start...
timeout /t 5 /nobreak >nul

echo.
echo [3/3] Opening browser...
echo.
echo ========================================
echo   CHOOSE YOUR TEST METHOD:
echo ========================================
echo.
echo A - Open in INCOGNITO mode (RECOMMENDED)
echo B - Open in NORMAL mode (requires cache clear)
echo.
choice /C AB /N /M "Select A or B: "

if errorlevel 2 goto normal
if errorlevel 1 goto incognito

:incognito
echo.
echo Opening in INCOGNITO mode...
echo.
echo ========================================
echo   INCOGNITO MODE INSTRUCTIONS:
echo ========================================
echo.
echo Browser will open normally, then:
echo 1. Press: Ctrl + Shift + N
echo 2. Go to: http://localhost:3000
echo 3. Login to your account
echo 4. LOOK: Pure WHITE background!
echo 5. Click theme button (top-right)
echo 6. WORKS!
echo.
start http://localhost:3000
goto end

:normal
echo.
echo Opening in NORMAL mode...
echo.
echo ========================================
echo   NORMAL MODE INSTRUCTIONS:
echo ========================================
echo.
echo IMPORTANT: You MUST clear cache first!
echo.
echo 1. Browser will open
echo 2. Press: Ctrl + Shift + Delete
echo 3. Select: "Cached images and files"
echo 4. Click: "Clear data"
echo 5. Then: Ctrl + Shift + R (hard refresh)
echo 6. Login and see white background!
echo.
start http://localhost:3000
goto end

:end
echo.
echo ========================================
echo   WHAT TO LOOK FOR:
echo ========================================
echo.
echo LIGHT MODE (Default):
echo   - Background: PURE WHITE
echo   - Text: Dark black
echo   - Button: Moon icon (moon emoji)
echo.
echo DARK MODE (Click moon button):
echo   - Background: Dark navy blue
echo   - Text: Pure white
echo   - Button: Sun icon (sun emoji)
echo.
echo ========================================
echo   TROUBLESHOOTING:
echo ========================================
echo.
echo If background is NOT white:
echo   1. Press: Ctrl + Shift + N (incognito)
echo   2. Go to: localhost:3000
echo   3. It WILL be white in incognito!
echo.
echo Cache is the ONLY issue if it doesn't work!
echo.
echo ========================================
echo.
echo Server is running in another window...
echo Press any key to STOP the server and exit
pause >nul

echo.
echo Stopping server...
taskkill /F /IM node.exe 2>nul
echo.
echo Done! White background test complete.
timeout /t 2 /nobreak >nul

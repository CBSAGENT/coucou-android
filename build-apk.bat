@echo off
REM Build APK script for Coucou Android (Windows)
REM Run from the project root: build-apk.bat

echo Building Coucou Android APK...

REM Check if we're in the right directory
if not exist "settings.gradle.kts" (
    echo Error: settings.gradle.kts not found. Run this script from the project root.
    exit /b 1
)

REM Clean previous builds
echo Cleaning previous builds...
call gradlew clean

REM Build debug APK
echo Building debug APK...
call gradlew assembleDebug

if %ERRORLEVEL% EQU 0 (
    echo.
    echo APK built successfully!
    echo.
    echo APK location:
    echo   app\build\outputs\apk\debug\app-debug.apk
    echo.
    echo To install on a connected device:
    echo   adb install app\build\outputs\apk\debug\app-debug.apk
    echo.
) else (
    echo.
    echo Build failed. Check the error messages above.
    exit /b 1
)

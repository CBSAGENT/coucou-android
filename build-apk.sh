#!/bin/bash

# Build APK script for Coucou Android
# Run from the project root: ./build-apk.sh

echo "Building Coucou Android APK..."

# Make sure we're in the right directory
if [ ! -f "settings.gradle.kts" ]; then
    echo "Error: settings.gradle.kts not found. Run this script from the project root."
    exit 1
fi

# Clean previous builds
echo "Cleaning previous builds..."
./gradlew clean

# Build debug APK
echo "Building debug APK..."
./gradlew assembleDebug

if [ $? -eq 0 ]; then
    echo ""
    echo "✅ APK built successfully!"
    echo ""
    echo "APK location:"
    echo "  app/build/outputs/apk/debug/app-debug.apk"
    echo ""
    echo "To install on a connected device:"
    echo "  adb install app/build/outputs/apk/debug/app-debug.apk"
    echo ""
    echo "Or use Android Studio to run it directly."
else
    echo ""
    echo "❌ Build failed. Check the error messages above."
    exit 1
fi

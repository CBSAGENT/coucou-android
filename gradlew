#!/usr/bin/env bash

# Wrapper script to handle missing gradle-wrapper.jar
set -e

SCRIPT_DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
GRADLE_WRAPPER_JAR="$SCRIPT_DIR/gradle/wrapper/gradle-wrapper.jar"
GRADLE_PROPERTIES="$SCRIPT_DIR/gradle/wrapper/gradle-wrapper.properties"

# Check if gradle wrapper exists, if not download it
if [ ! -f "$GRADLE_WRAPPER_JAR" ]; then
    echo "Downloading Gradle wrapper..."
    mkdir -p "$SCRIPT_DIR/gradle/wrapper"
    
    # Download gradle-wrapper.jar
    curl -L -o "$GRADLE_WRAPPER_JAR" https://services.gradle.org/distributions/gradle-7.6.1-bin.zip || \
    wget -O "$GRADLE_WRAPPER_JAR" https://services.gradle.org/distributions/gradle-7.6.1-bin.zip
    
    if [ ! -f "$GRADLE_WRAPPER_JAR" ]; then
        echo "Failed to download Gradle wrapper."
        exit 1
    fi
fi

# Run gradle
exec java -Dorg.gradle.appname=gradlew \
  -classpath "$GRADLE_WRAPPER_JAR" \
  org.gradle.wrapper.GradleWrapperMain "$@"

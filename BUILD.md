# APK Build Instructions

## Prerequisites

1. **Android SDK** - Install Android Studio or download the SDK directly
2. **Java 17** - Required for Gradle and Kotlin compilation
3. **Gradle** - Included in the project (wrapper)
4. **Connected Android device or emulator** (for installation)

## Build APK

### Option 1: Using the build script (Linux/macOS)

```bash
chmod +x build-apk.sh
./build-apk.sh
```

### Option 2: Using the build script (Windows)

```cmd
build-apk.bat
```

### Option 3: Manual Gradle build

```bash
# Debug APK
./gradlew assembleDebug

# Release APK (requires signing setup)
./gradlew assembleRelease
```

## Output

After a successful build, the APK will be located at:

```
app/build/outputs/apk/debug/app-debug.apk
```

## Install on device

### Using adb

```bash
adb install app/build/outputs/apk/debug/app-debug.apk
```

### Using Android Studio

1. Open Android Studio
2. Click **Run** → **Run 'app'**
3. Select your device/emulator
4. Click **OK**

## Troubleshooting

### "Gradle not found"
Make sure you're running from the project root directory.

### "Java version mismatch"
Check your Java version:
```bash
java -version
```
Must be Java 17 or higher.

### "Android SDK not found"
Set the `ANDROID_SDK_ROOT` environment variable:

**Linux/macOS:**
```bash
export ANDROID_SDK_ROOT=~/Android/Sdk
```

**Windows:**
```cmd
set ANDROID_SDK_ROOT=C:\Android\Sdk
```

### Build still fails
Check the full error log:
```bash
./gradlew assembleDebug --stacktrace
```

## Release Build

For production releases, you'll need to:

1. Create a signing keystore
2. Configure signing in `app/build.gradle.kts`
3. Run `./gradlew assembleRelease`

See Android documentation for detailed signing instructions.

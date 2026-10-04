# Coucou Android

A fresh Android version of Coucou with a Dynamic Island / Dynamic Notch-inspired interface for AI coding-agent activity, built in Kotlin + Jetpack Compose.

## Features

- Dynamic island compact/expanded states
- Mochi-inspired mascot and idle motion
- Agent/activity cards with soft glassmorphism styling
- Top safe-area layout for phones with cutouts
- Compose-first structure for fast iteration

## Project structure

- `app/` — Android application module
- `build.gradle.kts` — project-level Gradle config
- `settings.gradle.kts` — Gradle settings

## Run locally

1. Install Android Studio
2. Open the project
3. Let Gradle sync
4. Run the app on an emulator or a physical Android device

## Notes

This repo is a new Android implementation inspired by the desktop Coucou design, not a direct port of the Tauri desktop code. The goal is to preserve the same feel and interaction language: compact, friendly, and always available.

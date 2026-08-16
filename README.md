# Notes App - Task 3: API Integration, Networking & Dynamic Data Display

## Overview
This task extends the Notes App (built in Task 1 and Task 2 with Room Database + MVVM) by adding real-time online data. The app now fetches data from a public REST API and displays it dynamically, alongside the existing offline Notes feature — with a toggle button to switch between the two screens.

## API Used
- **JSONPlaceholder** — a free public REST API for testing and prototyping
- Base URL: `https://jsonplaceholder.typicode.com/`
- Endpoint used: `GET /posts` — returns a list of ~100 sample posts (id, userId, title, body)

## Architecture
The app follows **MVVM (Model-View-ViewModel)** with a Repository layer, consistent with Task 2:

```
UI (Jetpack Compose)
     ↓
ViewModel (PostViewModel)
     ↓
Repository (PostRepository)
     ↓
Retrofit API Service (ApiService)
     ↓
Remote Server (JSONPlaceholder API)
```

- **Model** — `Post.kt`: data class matching the API's JSON response shape
- **Network Layer** — `ApiService.kt` defines the API endpoint; `RetrofitInstance.kt` builds a singleton Retrofit client with Gson for JSON parsing
- **Repository** — `PostRepository.kt` abstracts the data source from the ViewModel
- **ViewModel** — `PostViewModel.kt` calls the repository inside a coroutine (`viewModelScope.launch`) and exposes `posts`, `isLoading`, and `error` as Compose state
- **UI** — `PostScreen()` (in `MainActivity.kt`) observes the ViewModel state and renders a loading indicator, error message, or a `LazyColumn` list of post cards depending on the current state

## Features Implemented
- ✅ Fetches live data from a public REST API using Retrofit
- ✅ Asynchronous networking handled with Kotlin Coroutines (`suspend` functions + `viewModelScope`)
- ✅ Dynamic list UI built with Jetpack Compose (`LazyColumn`, `Card`)
- ✅ Loading state shown while the request is in progress
- ✅ Error state shown if the network request fails (e.g., no internet)
- ✅ Toggle button to switch between the offline Notes screen (Room DB, Task 2) and the online Posts screen (API, Task 3) within the same app
- ✅ Clean MVVM architecture with separation between UI, ViewModel, Repository, and Network layers

## Tools & Libraries
- Kotlin
- Jetpack Compose
- Retrofit 2.9.0
- Gson Converter
- Kotlin Coroutines

## Screenshot
<img width="722" height="1600" alt="Image" src="https://github.com/user-attachments/assets/26d2f306-4457-4a82-bc9f-cc06cc84ac5e" />
<img width="1080" height="2392" alt="Image" src="https://github.com/user-attachments/assets/3ee4d216-0677-4708-8b9f-256067e7ac8f" />

## How to Test
1. Run the app — the Notes screen (local data) loads by default
2. Tap **"Show API Posts"** to switch to the live API screen
3. Observe the brief loading state, followed by the fetched list of posts
4. To test the error state, disable the emulator's internet connection (or enable airplane mode) and tap the button again
---


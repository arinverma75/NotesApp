# NotesApp - Android Application

A complete production-ready Android note-taking application with Firebase Authentication, offline data persistence, API integration, and multi-screen navigation built during an Android App Development Internship at MainCrafts.

---

## Project Overview

NotesApp is a fully functional notes application demonstrating professional Android development practices including MVVM architecture, Room database, REST API integration, Jetpack Compose UI, and secure Firebase authentication with Google Sign-In.

**Current Version:** Task 5 (Complete Authentication System)

---

## Features Implemented

### ✅ Task 1: Basic Notes App
- Create, read, update, and delete notes
- Clean UI with Jetpack Compose
- Floating Action Button (FAB) for adding new notes
- Note list display with scrolling

### ✅ Task 2: Room Database + MVVM Architecture
- Local SQLite database using Room ORM
- MVVM (Model-View-ViewModel) architecture
- Repository pattern for data access
- Offline data persistence with zero data loss on app restart
- Database entities: Note, NoteEntity

### ✅ Task 3: API Integration & Networking
- REST API integration using Retrofit
- Asynchronous network requests with Coroutines
- JSON serialization/deserialization with Gson
- Error handling and network retry logic
- API endpoints for posts/notes sync

### ✅ Task 4: Multi-Screen Navigation
- Jetpack Navigation Component implementation
- Navigation graph with multiple destinations
- Screen transitions:
  - Notes List Screen (Home)
  - Add/Edit Note Screen
  - Note Details Screen
- Back-stack management
- Safe Args for type-safe navigation

### ✅ Task 5: User Authentication & Session Management
- **Firebase Authentication** (Email/Password)
- **Google Sign-In with OAuth2**
- Session persistence across app restarts
- Protected screens requiring authentication
- Secure logout functionality
- App flow control based on user authentication state
- Error handling and user feedback

---

## Tech Stack

### Languages & Frameworks
- **Kotlin** - Primary language
- **Jetpack Compose** - Modern UI toolkit
- **Android Architecture Components** - MVVM, Navigation, LiveData

### Libraries & Dependencies
- **Firebase** - Authentication & Realtime Database
- **Room** - SQLite database
- **Retrofit** - REST API client
- **Coroutines** - Asynchronous programming
- **Gson** - JSON serialization
- **Google Play Services** - Google Sign-In, OAuth2

### Tools
- **Android Studio** - IDE
- **Git/GitHub** - Version control
- **Gradle** - Build system
- **Android Emulator & Physical Device Testing**

---

## Project Structure

```
NotesApp/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/example/notesapp/
│   │   │   │   ├── viewmodel/
│   │   │   │   │   ├── AuthViewModel.kt
│   │   │   │   │   ├── NotesViewModel.kt
│   │   │   │   │   └── PostViewModel.kt
│   │   │   │   ├── ui/theme/screens/
│   │   │   │   │   ├── LoginScreen.kt
│   │   │   │   │   ├── SignupScreen.kt
│   │   │   │   │   ├── HomeScreen.kt
│   │   │   │   │   ├── AddEditScreen.kt
│   │   │   │   │   └── NotesScreen.kt
│   │   │   │   ├── model/
│   │   │   │   │   ├── Note.kt
│   │   │   │   │   └── Post.kt
│   │   │   │   ├── database/
│   │   │   │   │   ├── NoteDao.kt
│   │   │   │   │   └── NoteDatabase.kt
│   │   │   │   ├── repository/
│   │   │   │   │   └── NoteRepository.kt
│   │   │   │   ├── api/
│   │   │   │   │   ├── APIService.kt
│   │   │   │   │   └── RetrofitInstance.kt
│   │   │   │   ├── navigation/
│   │   │   │   │   └── NavGraph.kt
│   │   │   │   ├── MainActivity.kt
│   │   │   │   ├── GoogleSignInHelper.kt
│   │   │   │   └── AppNavigation.kt
│   │   │   └── res/
│   │   │       ├── layout/
│   │   │       ├── values/strings.xml
│   │   │       └── drawable/
│   │   └── google-services.json
│   └── build.gradle.kts
├── build.gradle.kts (Project)
└── README.md
```

---

## Getting Started

### Prerequisites
- Android Studio (latest version)
- Android SDK 24+
- Java Development Kit (JDK) 11+
- Git
- Firebase account
- Google Cloud Console account

### Installation & Setup

#### 1. Clone the Repository
```bash
git clone https://github.com/arinverma75/NotesApp.git
cd NotesApp
```

#### 2. Firebase Setup
1. Go to [Firebase Console](https://console.firebase.google.com/)
2. Create a new project or use existing
3. Add Android app to project
4. Download `google-services.json`
5. Place it in `app/` folder
6. Enable Email/Password authentication in Firebase Console → Authentication → Sign-in method
7. Enable Google Sign-In the same way

#### 3. Get Web Client ID
1. Firebase Console → Project Settings → Apps → your Android app
2. Copy the **Web Client ID**
3. Open `res/values/strings.xml` and add:

```xml
<string name="default_web_client_id">YOUR_WEB_CLIENT_ID</string>
```

#### 4. Get SHA-1 Fingerprint
```bash
./gradlew signingReport
```
Copy the SHA1 value and add it to Firebase Console → Project Settings → Apps → your Android app → SHA certificate fingerprints

#### 5. Build & Run
```bash
./gradlew build
./gradlew installDebug
```
Or click **Run** in Android Studio

---

## Features in Detail

### Authentication Flow
1. **Launch** → Check if user is logged in
   - **Yes** → Navigate to Home (Notes)
   - **No** → Navigate to Login Screen

2. **Login Screen**
   - Email/Password login
   - Google Sign-In button
   - Link to Signup

3. **Signup Screen**
   - Create new account with email/password
   - Password validation (min 6 characters)
   - Navigate to Login after signup

4. **Home Screen (Protected)**
   - Only accessible after authentication
   - View all notes
   - Create, edit, delete notes
   - Logout button in top bar
   - Session persists across app restarts

5. **Logout**
   - Clears user session
   - Returns to Login screen
   - Prevents back navigation to Home

### Data Persistence
- **Local Storage**: Room Database stores notes
- **Session Storage**: Firebase maintains login state
- **Offline Access**: Notes available without internet
- **Sync**: API integration for cloud sync (Task 3)

### Security
- Firebase authentication handles credential management
- Session tokens stored securely
- Protected screens require authentication
- No hardcoded credentials
- SHA-1 verification for Google Sign-In

---

## Usage

### Create a Note
1. Login/Signup
2. Tap **"+" (FAB)** button
3. Enter title and content
4. Tap **Save**

### Edit a Note
1. Tap on a note from the list
2. Tap **Edit** icon
3. Modify content
4. Tap **Save**

### Delete a Note
1. Tap on a note
2. Tap **Delete** icon
3. Confirm deletion

### Logout
1. Tap **Logout** icon in top-right corner
2. Confirm logout
3. Redirected to Login screen

---

## Testing

### Test Cases Covered
✅ Signup works with valid email/password  
✅ Login works with existing credentials  
✅ Wrong credentials show error message  
✅ Session persists after app restart  
✅ Logout clears session and returns to login  
✅ Google Sign-In completes authentication  
✅ Protected screens require authentication  
✅ Create/Edit/Delete notes work offline  
✅ Notes sync with database  
✅ API integration retrieves posts  

### Manual Testing
```
1. Test signup with new email
2. Test login with wrong password (should fail)
3. Test Google Sign-In
4. Create 3 notes
5. Edit one note
6. Delete one note
7. Force-close app → reopen (session should persist)
8. Logout → verify login screen shows
9. Try accessing home without login (should redirect)
10. Test API call to fetch posts
```

---

## Learning Outcomes

After completing Tasks 1-5, I've learned to:

✅ **Build production-ready Android apps** with modern architecture  
✅ **Implement MVVM pattern** with ViewModel and StateFlow  
✅ **Design local databases** using Room ORM  
✅ **Integrate REST APIs** with Retrofit and Coroutines  
✅ **Create multi-screen navigation** with Jetpack Navigation  
✅ **Implement user authentication** with Firebase  
✅ **Add Google Sign-In with OAuth2** integration  
✅ **Manage user sessions** with persistent login  
✅ **Handle errors gracefully** with proper UX feedback  
✅ **Write secure, production-ready code** following best practices  

---

## Challenges & Solutions

| Challenge | Solution |
|-----------|----------|
| Room database migrations | Used proper entity versioning and fallback strategies |
| Retrofit error handling | Implemented custom error models and logging |
| Navigation back-stack issues | Used `popUpTo` with `inclusive = true` for logout flow |
| Google Sign-In error 10 | Fixed SHA-1 fingerprint mismatch in Firebase config |
| Session persistence | Used Firebase's built-in token management |
| Jetpack Compose state management | Implemented StateFlow for reactive UI updates |

---

## Future Enhancements

- [ ] Cloud backup with Firestore
- [ ] Note sharing between users
- [ ] Rich text editing (bold, italic, colors)
- [ ] Image attachments in notes
- [ ] Note categories/tags
- [ ] Search functionality
- [ ] Dark theme support
- [ ] Biometric authentication
- [ ] Offline sync when online
- [ ] Export notes as PDF

---

## References & Documentation

### Official Documentation
- [Firebase Authentication](https://firebase.google.com/docs/auth)
- [Android Room Database](https://developer.android.com/training/data-storage/room)
- [Retrofit HTTP Client](https://square.github.io/retrofit/)
- [Jetpack Compose](https://developer.android.com/jetpack/compose)
- [Navigation Component](https://developer.android.com/guide/navigation)

### Learning Resources
- [Android Architecture Patterns](https://developer.android.com/topic/architecture)
- [Kotlin Coroutines](https://kotlinlang.org/docs/coroutines-overview.html)
- [MVVM Architecture](https://developer.android.com/jetpack/guide)

---

## Author

**Arin Verma**  
Android App Development Intern @ MainCrafts  
B.Tech Computer Science (AI Specialization) @ S.R Institute of Management and Technology  
📧 arinverma75@gmail.com  
🔗 [GitHub](https://github.com/arinverma75)

---

## License

This project is open source and available under the MIT License.

---

## Acknowledgments

- MainCrafts for the internship opportunity
- Firebase team for authentication services
- Android Developer Documentation
- Open-source community for libraries and tools

---

**Last Updated:** September 2026  
**Status:** ✅ Task 5 Complete - Production Ready

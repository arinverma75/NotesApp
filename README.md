# Notes App - Task 2: Room Database Integration 📝

A modern Android Notes Application built using **Jetpack Compose** and integrated with **Room Database** for local persistent storage, following the **MVVM Architecture** pattern.

---

## 🚀 What's New in Task 2?
In Task 1, the app utilized in-memory state management. In **Task 2**, the app has been upgraded to support full local persistence using Android's **Room Persistence Library**, allowing notes to stay saved even after closing or restarting the app.

---

## ✨ Features
* **Persistent Storage**: Save, view, and delete notes locally using Room DB.
* **Jetpack Compose UI**: Clean, declarative UI built with Material 3 design components.
* **Reactive Data Flow**: Asynchronous data streams powered by Kotlin **Coroutines** and **StateFlow**.
* **Clean Architecture**: Structured separation of concerns using the MVVM design pattern.

---

## 🛠️ Tech Stack & Libraries
* **Language**: [Kotlin](https://kotlinlang.org/)
* **UI Toolkit**: [Jetpack Compose](https://developer.android.com/jetpack/compose) (Material 3)
* **Local Database**: [Room Database](https://developer.android.com/training/data-storage/room)
* **Architecture**: MVVM (Model-View-ViewModel)
* **Asynchronous / Streams**: Kotlin Coroutines & `Flow` / `StateFlow`
* **Dependency Injection / Factory**: Custom `ViewModelProvider.Factory`

---

## 🏗️ Architecture Overview

The app follows the standard Android recommended architecture:

[ UI (Jetpack Compose) ] ➔ [ ViewModel (NotesViewModel) ] ➔ [ Repository (NoteRepository) ] ➔ [ DAO (NoteDao) ] ➔ [ Room Database (SQLite) ]

### Key Components:
1. **`NoteEntity`**: Defines the SQLite table structure for notes (`id`, `title`, `description`).
2. **`NoteDao`**: Contains SQL query methods (`insert`, `delete`, `getAllNotes`).
3. **`NoteDatabase`**: Thread-safe singleton instance of the Room Database.
4. **`NoteRepository`**: Serves as a single source of truth for accessing database operations.
5. **`NotesViewModel`**: Manages UI state and handles coroutine scopes for asynchronous DB operations.

---

## 📱 How to Run
1. Clone the repository:
   ```bash
   git clone [https://github.com/arinverma75/NotesApp.git](https://github.com/arinverma75/NotesApp.git)

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

## Screenshot

<img width="1080" height="2400" alt="Image" src="https://github.com/user-attachments/assets/1cf500e5-da70-4545-b36a-ef58562968a1" />
<img width="1080" height="2400" alt="Image" src="https://github.com/user-attachments/assets/8258a8fe-38d8-40ba-9959-bf97521bf177" />
<img width="1080" height="2400" alt="Image" src="https://github.com/user-attachments/assets/dd581a07-a733-4f38-9618-f2ecc374b753" />
<img width="1080" height="2400" alt="Image" src="https://github.com/user-attachments/assets/2e2a233f-f999-450b-8349-5dc3e90dcb4d" />

<img width="1904" height="1036" alt="Image" src="https://github.com/user-attachments/assets/023154b4-5efa-453a-afb2-589897246f98" />
<img width="1920" height="1080" alt="Image" src="https://github.com/user-attachments/assets/92d7a9aa-050f-4b4e-b0b3-7fee681e3e37" />
<img width="1920" height="1080" alt="Image" src="https://github.com/user-attachments/assets/a228cfa6-ef3d-49e2-bf1c-89f6d145c46b" />
<img width="1920" height="1080" alt="Image" src="https://github.com/user-attachments/assets/44f082fc-c49c-4132-8498-082fe452b2cc" />

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

package com.example.notesapp.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.notesapp.model.Note

class NotesViewModel : ViewModel() {

    private val _notes = mutableStateListOf<Note>()
    val notes: List<Note> = _notes

    fun addNote(title: String, description: String) {
        if (title.isNotBlank() && description.isNotBlank()) {
            _notes.add(
                Note(
                    id = _notes.size + 1,
                    title = title,
                    description = description
                )
            )
        }
    }

    fun deleteNote(note: Note) {
        _notes.remove(note)
    }
}
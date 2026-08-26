package com.example.notesapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.notesapp.NoteEntity
import com.example.notesapp.NoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.map

class NotesViewModel(private val repository: NoteRepository) : ViewModel() {

    val notes: Flow<List<NoteEntity>> = repository.allNotes

    fun addNote(title: String, description: String) {
        viewModelScope.launch {
            val note = NoteEntity(title = title, description = description)
            repository.insert(note)
        }
    }

    fun deleteNote(note: NoteEntity) {
        viewModelScope.launch {
            repository.delete(note)
        }
    }
    fun updateNote(note: NoteEntity) {
        viewModelScope.launch {
            repository.update(note)
        }
    }
    fun getItemById(id: Int): Flow<NoteEntity?>{
        return notes.map{list -> list.find{it.id == id}}
    }
}


class NotesViewModelFactory(private val repository: NoteRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NotesViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return NotesViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
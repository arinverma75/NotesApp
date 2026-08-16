package com.example.notesapp.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notesapp.PostRepository
import com.example.notesapp.model.Post
import kotlinx.coroutines.launch

class PostViewModel(private val repository: PostRepository = PostRepository()) : ViewModel() {

    var posts = mutableStateOf<List<Post>>(emptyList())
    var isLoading = mutableStateOf(false)
    var error = mutableStateOf("")

    fun fetchPosts() {
        viewModelScope.launch {
            isLoading.value = true
            try {
                posts.value = repository.getPosts()
                error.value = ""
            } catch (e: Exception) {
                error.value = "Failed to load data: ${e.message}"
            }
            isLoading.value = false
        }
    }
}
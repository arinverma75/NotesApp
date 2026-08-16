package com.example.notesapp

import com.example.notesapp.model.Post

class PostRepository {
    suspend fun getPosts(): List<Post> {
        return RetrofitInstance.api.getPosts()
    }
}
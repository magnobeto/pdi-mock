package com.example.retrofitdemo.data.model

data class AlbumsItem(
    val id: Int,
    val title: String,
    val userId: Int
)

// Data class baseado em na API de teste "https://jsonplaceholder.typicode.com/", especificamente
// sobre album
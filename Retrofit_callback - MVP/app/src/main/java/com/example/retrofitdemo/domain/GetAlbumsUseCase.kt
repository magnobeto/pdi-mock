package com.example.retrofitdemo.domain

import com.example.retrofitdemo.data.model.Albums

class GetAlbumsUseCase(private val repository: AlbumsRepository) {
    fun execute(callback: (albums: Albums) -> Unit) {
        repository.getAlbums {
            callback(it)
        }
    }}
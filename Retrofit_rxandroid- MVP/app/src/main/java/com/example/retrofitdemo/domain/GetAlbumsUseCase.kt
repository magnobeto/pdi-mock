package com.example.retrofitdemo.domain

import com.example.retrofitdemo.data.model.Albums

class GetAlbumsUseCase(private val repository: AlbumsRepository) {
    suspend fun execute(): Albums = repository.getAlbums()
}
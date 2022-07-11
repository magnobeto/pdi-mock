package com.example.retrofitdemo.domain

import com.example.retrofitdemo.data.model.Albums
import io.reactivex.rxjava3.core.Observer

class GetAlbumsUseCase(private val repository: AlbumsRepository) {
    fun execute(observer: Observer<Albums>) = repository.getAlbums(observer)
}
package com.example.retrofitdemo.domain

import com.example.retrofitdemo.data.model.Albums
import io.reactivex.rxjava3.core.Observer

interface AlbumsRepository {
    fun getAlbums(observer: Observer<Albums>)
}
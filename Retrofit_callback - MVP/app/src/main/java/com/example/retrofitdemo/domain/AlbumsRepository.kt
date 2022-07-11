package com.example.retrofitdemo.domain

import com.example.retrofitdemo.data.model.Albums

interface AlbumsRepository {
    fun getAlbums(callback : (albums: Albums) -> Unit)
}
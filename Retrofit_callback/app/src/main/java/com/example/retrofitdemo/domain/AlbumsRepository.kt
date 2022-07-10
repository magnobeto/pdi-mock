package com.example.retrofitdemo.domain

import com.example.retrofitdemo.data.model.Albums
import retrofit2.Call

interface AlbumsRepository {
    fun getAlbums(callback : (albums: Albums) -> Unit)
}
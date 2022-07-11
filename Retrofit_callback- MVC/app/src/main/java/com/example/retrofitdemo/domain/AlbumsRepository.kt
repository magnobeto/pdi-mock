package com.example.retrofitdemo.domain

import com.example.retrofitdemo.data.model.Albums

interface AlbumsRepository {
    suspend fun getAlbums(): Albums
}
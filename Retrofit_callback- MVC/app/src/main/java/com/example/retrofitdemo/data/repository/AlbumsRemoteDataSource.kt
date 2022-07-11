package com.example.retrofitdemo.data.repository

import com.example.retrofitdemo.data.model.Albums
import retrofit2.Response

interface AlbumsRemoteDataSource {

    suspend fun getAlbums(): Response<Albums>
}
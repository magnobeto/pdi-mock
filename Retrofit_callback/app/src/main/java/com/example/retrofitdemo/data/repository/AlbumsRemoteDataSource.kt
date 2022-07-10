package com.example.retrofitdemo.data.repository

import com.example.retrofitdemo.data.model.Albums
import retrofit2.Call

interface AlbumsRemoteDataSource {

    fun getAlbums(): Call<Albums>
}
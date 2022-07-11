package com.example.retrofitdemo.data.repository

import com.example.retrofitdemo.data.model.Albums
import retrofit2.Call
import retrofit2.Response

interface AlbumsRemoteDataSource {

    fun getAlbums(): Call<Albums>
}
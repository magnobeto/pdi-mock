package com.example.retrofitdemo.data.repository

import com.example.retrofitdemo.data.api.AlbumService
import com.example.retrofitdemo.data.model.Albums
import retrofit2.Call

class AlbumsRemoteDataSourceImpl(private val albumService: AlbumService) : AlbumsRemoteDataSource {
    override fun getAlbums(): Call<Albums> = albumService.getAlbums()
}
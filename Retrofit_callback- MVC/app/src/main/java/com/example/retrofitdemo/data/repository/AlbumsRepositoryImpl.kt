package com.example.retrofitdemo.data.repository

import android.util.Log
import com.example.retrofitdemo.data.model.Albums
import com.example.retrofitdemo.domain.AlbumsRepository
import java.lang.Exception

class AlbumsRepositoryImpl(
    private val albumsRemoteDataSource: AlbumsRemoteDataSource
) : AlbumsRepository {
    override suspend fun getAlbums(): Albums = getAlbumsFromAPI()

    private suspend fun getAlbumsFromAPI(): Albums {
        lateinit var albumsList: Albums
        try {
            val response = albumsRemoteDataSource.getAlbums()
            response.body()?.let {
                albumsList = it
            }
            return albumsList
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        return albumsList
    }
}
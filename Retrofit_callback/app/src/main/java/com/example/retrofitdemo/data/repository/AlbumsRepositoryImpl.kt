package com.example.retrofitdemo.data.repository

import android.util.Log
import com.example.retrofitdemo.data.model.Albums
import com.example.retrofitdemo.domain.AlbumsRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

class AlbumsRepositoryImpl(
    private val albumsRemoteDataSource: AlbumsRemoteDataSource
) : AlbumsRepository {

    override fun getAlbums(callback: (albums: Albums) -> Unit) {
        getAlbumsFromAPI {
            callback(it)
        }
    }

    private fun getAlbumsFromAPI(callback: (albums: Albums) -> Unit) {
        val call = albumsRemoteDataSource.getAlbums()
        call.enqueue(object : Callback<Albums> {
            override fun onResponse(call: Call<Albums>, response: Response<Albums>) {
                response.body()?.let {
                    val albumsList = it
                    callback(albumsList)
                }
            }

            override fun onFailure(call: Call<Albums>, t: Throwable) {
                Log.i("MyTag", t.message.toString())
            }
        })
    }
}
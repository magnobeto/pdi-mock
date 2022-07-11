package com.example.retrofitdemo.data.repository

import android.util.Log
import com.example.retrofitdemo.data.model.Albums
import com.example.retrofitdemo.domain.AlbumsRepository
import io.reactivex.rxjava3.core.Observer
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

class AlbumsRepositoryImpl(
    private val albumsRemoteDataSource: AlbumsRemoteDataSource
) : AlbumsRepository {
    override fun getAlbums(observer: Observer<Albums>) =
        albumsRemoteDataSource.getAlbumsFromApiRX(observer)
}
package com.example.retrofitdemo.data.repository

import com.example.retrofitdemo.data.model.Albums
import com.example.retrofitdemo.domain.AlbumsRepository
import io.reactivex.rxjava3.core.Observer

class AlbumsRepositoryImpl(
    private val albumsRemoteDataSource: AlbumsRemoteDataSource
) : AlbumsRepository {
    override fun getAlbums(observer: Observer<Albums>) =
        albumsRemoteDataSource.getAlbumsFromApiRX(observer)
}
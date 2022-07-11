package com.example.retrofitdemo.data.repository

import com.example.retrofitdemo.data.api.AlbumService
import com.example.retrofitdemo.data.model.Albums
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.schedulers.Schedulers

class AlbumsRemoteDataSourceImpl(private val albumService: AlbumService) : AlbumsRemoteDataSource {
    override fun getAlbumsFromApiRX(observer: Observer<Albums>) {
        return albumService.getAlbums()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(observer)
    }
}
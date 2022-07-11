package com.example.retrofitdemo.data.repository

import com.example.retrofitdemo.data.model.Albums
import io.reactivex.rxjava3.core.Observer

interface AlbumsRemoteDataSource {
    fun getAlbumsFromApiRX(observer: Observer<Albums>)
}
package com.example.retrofitdemo.presentation.mvc

import com.example.retrofitdemo.data.model.Albums
import io.reactivex.rxjava3.core.Observer

interface IMainController {
    fun start(initView: () -> Unit)
    fun getAlbums()
    fun getAlbumsObserverRX(): Observer<Albums>
}

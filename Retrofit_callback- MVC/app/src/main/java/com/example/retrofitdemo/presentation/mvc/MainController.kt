package com.example.retrofitdemo.presentation.mvc

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.retrofitdemo.data.model.Albums
import com.example.retrofitdemo.domain.GetAlbumsUseCase
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class MainController : IMainController, KoinComponent {

    private var albumsLV = MutableLiveData<Albums>()
    val albums: LiveData<Albums> = albumsLV

    private val getAlbumsUseCase: GetAlbumsUseCase by inject()

    override fun start(initView: () -> Unit) {
        initView.invoke()
    }

    override suspend fun getAlbums() {
        val response = getAlbumsUseCase.execute()
        albumsLV.postValue(response)
    }
}
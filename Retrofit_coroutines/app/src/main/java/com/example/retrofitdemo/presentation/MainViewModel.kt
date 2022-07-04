package com.example.retrofitdemo.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.retrofitdemo.data.model.Albums
import com.example.retrofitdemo.domain.GetAlbumsUseCase

class MainViewModel(private val getAlbumsUseCase: GetAlbumsUseCase) : ViewModel() {

    private var albumsLV = MutableLiveData<Albums>()
    val albums: LiveData<Albums> = albumsLV

    suspend fun getAlbums(){
        val response = getAlbumsUseCase.execute()
        albumsLV.postValue(response)
    }
}
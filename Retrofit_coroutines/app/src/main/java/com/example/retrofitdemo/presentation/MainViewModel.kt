package com.example.retrofitdemo.presentation

import androidx.lifecycle.ViewModel
import com.example.retrofitdemo.data.model.Albums
import com.example.retrofitdemo.domain.GetAlbumsUseCase

class MainViewModel(private val getAlbumsUseCase: GetAlbumsUseCase) : ViewModel() {

    suspend fun getAlbums(): Albums = getAlbumsUseCase.execute()
}
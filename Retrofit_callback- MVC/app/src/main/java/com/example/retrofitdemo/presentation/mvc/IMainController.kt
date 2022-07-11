package com.example.retrofitdemo.presentation.mvc

interface IMainController {
    fun start(initView: () -> Unit)
    suspend fun getAlbums()
}

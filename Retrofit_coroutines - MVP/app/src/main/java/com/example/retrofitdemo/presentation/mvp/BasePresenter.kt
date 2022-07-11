package com.example.retrofitdemo.presentation.mvp

interface BasePresenter {
    fun start(initView: () -> Unit)
}
package com.example.retrofitdemo.presentation.mvp

interface BaseView<T> {
    var presenter : T
    fun bindViews()
}
package com.example.retrofitdemo.presentation.di

import org.koin.dsl.module

val appModule = module {

    // single instance of HelloRepository
//    single<HelloRepository> { HelloRepositoryImpl() }

    // Simple Presenter Factory
//    factory { MySimplePresenter(get()) }
}
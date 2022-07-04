package com.example.retrofitdemo.presentation.di

import com.example.retrofitdemo.RetrofitInstance
import com.example.retrofitdemo.data.api.AlbumService
import com.example.retrofitdemo.data.repository.AlbumsRemoteDataSource
import com.example.retrofitdemo.data.repository.AlbumsRemoteDataSourceImpl
import com.example.retrofitdemo.data.repository.AlbumsRepositoryImpl
import com.example.retrofitdemo.domain.AlbumsRepository
import com.example.retrofitdemo.domain.GetAlbumsUseCase
import com.example.retrofitdemo.presentation.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel {
        MainViewModel(get<GetAlbumsUseCase>())
    }

    single<GetAlbumsUseCase> {
        GetAlbumsUseCase(get<AlbumsRepository>())
    }

    single<AlbumsRepository> {
        AlbumsRepositoryImpl(get<AlbumsRemoteDataSource>())
    }

    single<AlbumsRemoteDataSource> {
        AlbumsRemoteDataSourceImpl(get<AlbumService>())
    }
}
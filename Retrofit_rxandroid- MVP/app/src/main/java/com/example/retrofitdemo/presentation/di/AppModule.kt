package com.example.retrofitdemo.presentation.di

import com.example.retrofitdemo.BuildConfig
import com.example.retrofitdemo.data.api.AlbumService
import com.example.retrofitdemo.data.repository.AlbumsRemoteDataSource
import com.example.retrofitdemo.data.repository.AlbumsRemoteDataSourceImpl
import com.example.retrofitdemo.data.repository.AlbumsRepositoryImpl
import com.example.retrofitdemo.domain.AlbumsRepository
import com.example.retrofitdemo.domain.GetAlbumsUseCase
import com.google.gson.GsonBuilder
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {

    single<GetAlbumsUseCase> {
        GetAlbumsUseCase(get<AlbumsRepository>())
    }

    single<AlbumsRepository> {
        AlbumsRepositoryImpl(get<AlbumsRemoteDataSource>())
    }

    single<AlbumsRemoteDataSource> {
        AlbumsRemoteDataSourceImpl(get<AlbumService>())
    }

    single<AlbumService> {
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
            .create(AlbumService::class.java)
    }
}
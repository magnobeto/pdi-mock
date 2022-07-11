package com.example.retrofitdemo.data.api

import com.example.retrofitdemo.data.model.Albums
import com.example.retrofitdemo.data.model.AlbumsItem
import io.reactivex.rxjava3.core.Observable
import retrofit2.Response
import retrofit2.http.*

interface AlbumService {

    @GET("/albums")
    fun getAlbums(): Observable<Albums>

    @GET("/albums")
    suspend fun getSortedAlbums(@Query ("userId") userId: Int): Response<Albums>

    @GET("/albums/{id}")
    suspend fun getAlbum(@Path(value = "id") albumId: Int): Response<AlbumsItem>

    @POST("/albums")
    suspend fun uploadAlbum(@Body album: AlbumsItem) : Response<AlbumsItem>
}
package com.example.retrofitdemo.data.repository

import com.example.retrofitdemo.data.api.AlbumService

class AlbumsRemoteDataSourceImpl(private val albumService: AlbumService) : AlbumsRemoteDataSource {
    override suspend fun getAlbums() = albumService.getAlbums()
}
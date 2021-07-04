package com.mikef.lastfm.data.album

import com.mikef.lastfm.network.album.AlbumResponse

class AlbumRepositoryImpl(private val albumService: AlbumService) : AlbumRepository {

    override suspend fun getAlbumInfo(artistName: String, album: String): AlbumResponse {
        return albumService.fetchAlbumInfo(artistName = artistName, album = album)
    }
}
package com.mikef.lastfm.data.album

import com.mikef.lastfm.data.RepoResult
import com.mikef.lastfm.network.data.album.Album

interface AlbumRepository {

    suspend fun getAlbumInfo(
        artistName: String,
        albumName: String
    ): RepoResult<AlbumRepositoryImpl.AlbumResponse>

    suspend fun saveAlbum(album: Album)

    suspend fun deleteAlbum(album: Album)

}
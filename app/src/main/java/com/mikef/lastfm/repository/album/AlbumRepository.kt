package com.mikef.lastfm.repository.album

import com.mikef.lastfm.network.data.album.Album
import com.mikef.lastfm.repository.RepoResult

interface AlbumRepository {

    suspend fun getAlbumInfo(
        artistName: String,
        albumName: String
    ): RepoResult<AlbumRepositoryImpl.AlbumResponse>

    suspend fun saveAlbum(album: Album)

    suspend fun deleteAlbum(album: Album)

}
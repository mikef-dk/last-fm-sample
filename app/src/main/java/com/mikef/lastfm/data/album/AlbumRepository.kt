package com.mikef.lastfm.data.album

import com.mikef.lastfm.network.album.Album

interface AlbumRepository {

    suspend fun getAlbumInfo(artistName: String, albumName: String): Album

    suspend fun saveAlbum(album: Album)

    suspend fun deleteAlbum(album: Album)

}
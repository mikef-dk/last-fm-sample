package com.mikef.lastfm.data.album

import com.mikef.lastfm.network.album.AlbumResponse

interface AlbumRepository {

    suspend fun getAlbumInfo(artistName: String, album: String): AlbumResponse

}
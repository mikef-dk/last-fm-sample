package com.mikef.lastfm.data.album

import com.mikef.lastfm.network.album.AlbumResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface AlbumService {

    @GET("?method=album.getinfo")
    suspend fun fetchAlbumInfo(
        @Query("artist") artistName: String,
        @Query("album") album: String
    ): AlbumResponse

}
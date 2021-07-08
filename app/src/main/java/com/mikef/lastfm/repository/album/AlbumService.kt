package com.mikef.lastfm.repository.album

import com.mikef.lastfm.network.data.album.AlbumResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface AlbumService {

    @GET("?method=album.getinfo")
    suspend fun fetchAlbumInfo(
        @Query("artist") artistName: String,
        @Query("album") album: String
    ): AlbumResponse

}
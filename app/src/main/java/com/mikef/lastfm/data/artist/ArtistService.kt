package com.mikef.lastfm.data.artist

import com.mikef.lastfm.network.data.artistAlbum.TopAlbumResponse
import com.mikef.lastfm.network.data.artistInfo.ArtistInfoResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ArtistService {

    @GET("?method=artist.getinfo")
    suspend fun fetchInfo(@Query("artist") artistName: String): ArtistInfoResponse

    @GET("?method=artist.gettopalbums")
    suspend fun fetchTopAlbums(@Query("artist") artistName: String): TopAlbumResponse

}
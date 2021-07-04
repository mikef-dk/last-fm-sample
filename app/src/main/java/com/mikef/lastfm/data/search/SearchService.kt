package com.mikef.lastfm.data.search

import com.mikef.lastfm.network.artist.ArtistSearchResult
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchService {

    @GET("?method=artist.search")
    suspend fun searchArtist(@Query("artist") artistName: String): ArtistSearchResult

}
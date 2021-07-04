package com.mikef.lastfm.data.search

import com.mikef.lastfm.network.artist.ArtistSearchResult
import retrofit2.http.Query

interface SearchRepository {

    suspend fun searchArtist(artistName: String): ArtistSearchResult

}
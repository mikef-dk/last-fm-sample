package com.mikef.lastfm.data.search

import com.mikef.lastfm.network.ApiResult
import com.mikef.lastfm.network.artist.ArtistSearchResult

interface SearchRepository {

    suspend fun searchArtist(artistName: String): ApiResult<ArtistSearchResult>

}
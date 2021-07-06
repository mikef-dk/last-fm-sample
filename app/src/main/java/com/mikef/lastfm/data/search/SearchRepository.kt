package com.mikef.lastfm.data.search

import com.mikef.lastfm.data.RepoResult
import com.mikef.lastfm.network.data.artist.ArtistSearchResult

interface SearchRepository {

    suspend fun searchArtist(artistName: String): RepoResult<ArtistSearchResult>

}
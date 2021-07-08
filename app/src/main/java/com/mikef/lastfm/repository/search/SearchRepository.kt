package com.mikef.lastfm.repository.search

import com.mikef.lastfm.network.data.artist.ArtistSearchResult
import com.mikef.lastfm.repository.RepoResult

interface SearchRepository {

    suspend fun searchArtist(artistName: String): RepoResult<ArtistSearchResult>

}
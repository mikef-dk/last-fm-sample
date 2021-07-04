package com.mikef.lastfm.data.search

import com.mikef.lastfm.network.artist.ArtistSearchResult

class SearchRepositoryImpl(
    private val searchService: SearchService
) : SearchRepository {

    override suspend fun searchArtist(artistName: String): ArtistSearchResult =
        searchService.searchArtist(artistName)

}
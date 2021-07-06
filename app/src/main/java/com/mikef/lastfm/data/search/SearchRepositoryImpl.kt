package com.mikef.lastfm.data.search

import com.mikef.lastfm.data.RepoResult
import com.mikef.lastfm.network.data.artist.ArtistSearchResult

class SearchRepositoryImpl(
    private val searchService: SearchService
) : SearchRepository {

    override suspend fun searchArtist(artistName: String): RepoResult<ArtistSearchResult> {
        return try {
            val result = searchService.searchArtist(artistName)
            RepoResult.Success(result)
        } catch (e: Exception) {
            RepoResult.Failure(e)
        }
    }

}
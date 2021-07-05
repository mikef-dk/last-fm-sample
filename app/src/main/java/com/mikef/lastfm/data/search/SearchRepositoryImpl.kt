package com.mikef.lastfm.data.search

import com.mikef.lastfm.network.ApiResult
import com.mikef.lastfm.network.artist.ArtistSearchResult

class SearchRepositoryImpl(
    private val searchService: SearchService
) : SearchRepository {

    override suspend fun searchArtist(artistName: String): ApiResult<ArtistSearchResult> {
        return try {
            val result = searchService.searchArtist(artistName)
            ApiResult.Success(result)
        } catch (e: Exception) {
            ApiResult.Failure(e)
        }
    }

}
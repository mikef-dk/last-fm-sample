package com.mikef.lastfm.repository.artist

import com.mikef.lastfm.network.data.artistAlbum.TopAlbumResponse
import com.mikef.lastfm.network.data.artistInfo.ArtistInfoResponse
import com.mikef.lastfm.repository.RepoResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext

class ArtistRepositoryImpl(private val artistService: ArtistService) : ArtistRepository {

    override suspend fun fetchArtistData(artistName: String): RepoResult<Pair<ArtistInfoResponse, TopAlbumResponse>> {
        return withContext(Dispatchers.IO) {
            try {
                val infoDeferred =
                    async { fetchInfo(artistName = artistName) }
                val topAlbumsDeferred =
                    async { fetchTopAlbums(artistName = artistName) }

                val artistInfo = infoDeferred.await()
                val topAlbums = topAlbumsDeferred.await()

                RepoResult.Success(Pair(artistInfo, topAlbums))
            } catch (e: Exception) {
                RepoResult.Failure(e)
            }
        }
    }

    private suspend fun fetchInfo(artistName: String): ArtistInfoResponse {
        return artistService.fetchInfo(artistName)
    }

    private suspend fun fetchTopAlbums(artistName: String): TopAlbumResponse {
        return artistService.fetchTopAlbums(artistName)
    }

}
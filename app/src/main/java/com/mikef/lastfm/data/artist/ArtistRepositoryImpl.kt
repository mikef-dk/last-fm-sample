package com.mikef.lastfm.data.artist

import com.mikef.lastfm.network.artistAlbum.TopAlbumResponse
import com.mikef.lastfm.network.artistInfo.ArtistInfoResponse

class ArtistRepositoryImpl(private val artistService: ArtistService) : ArtistRepository {

    override suspend fun fetchInfo(artistName: String): ArtistInfoResponse {
        return artistService.fetchInfo(artistName)
    }

    override suspend fun fetchTopAlbums(artistName: String): TopAlbumResponse {
        return artistService.fetchTopAlbums(artistName)
    }

}
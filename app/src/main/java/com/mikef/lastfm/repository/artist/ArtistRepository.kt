package com.mikef.lastfm.repository.artist

import com.mikef.lastfm.network.data.artistAlbum.TopAlbumResponse
import com.mikef.lastfm.network.data.artistInfo.ArtistInfoResponse
import com.mikef.lastfm.repository.RepoResult

interface ArtistRepository {

    suspend fun fetchArtistData(
        artistName: String
    ): RepoResult<Pair<ArtistInfoResponse, TopAlbumResponse>>

}
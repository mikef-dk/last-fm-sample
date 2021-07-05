package com.mikef.lastfm.data.artist

import com.mikef.lastfm.network.ApiResult
import com.mikef.lastfm.network.data.artistAlbum.TopAlbumResponse
import com.mikef.lastfm.network.data.artistInfo.ArtistInfoResponse

interface ArtistRepository {

    // TODO: Remove
    suspend fun fetchInfo(artistName: String): ArtistInfoResponse

    // TODO: Remove
    suspend fun fetchTopAlbums(artistName: String): TopAlbumResponse

    suspend fun fetchArtistData(artistName: String) : ApiResult<Pair<ArtistInfoResponse, TopAlbumResponse>>

}
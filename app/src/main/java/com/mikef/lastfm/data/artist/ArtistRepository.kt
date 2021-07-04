package com.mikef.lastfm.data.artist

import com.mikef.lastfm.network.artistAlbum.TopAlbumResponse
import com.mikef.lastfm.network.artistInfo.ArtistInfoResponse

interface ArtistRepository {

    suspend fun fetchInfo(artistName: String): ArtistInfoResponse

    suspend fun fetchTopAlbums(artistName: String): TopAlbumResponse

}
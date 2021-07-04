package com.mikef.lastfm.network.artistInfo


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ArtistInfoResponse(
    @SerialName("artist")
    val artist: Artist
)
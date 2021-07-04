package com.mikef.lastfm.network.artist


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ArtistMatches(
    @SerialName("artist")
    val artist: List<Artist>
)
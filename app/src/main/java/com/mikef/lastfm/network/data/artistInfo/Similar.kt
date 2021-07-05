package com.mikef.lastfm.network.data.artistInfo


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Similar(
    @SerialName("artist")
    val artist: List<ArtistX>
)
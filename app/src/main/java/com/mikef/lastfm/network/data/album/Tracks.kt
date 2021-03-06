package com.mikef.lastfm.network.data.album


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Tracks(
    @SerialName("track")
    val track: List<Track>
)
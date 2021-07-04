package com.mikef.lastfm.network.album


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Track(
    @SerialName("artist")
    val artist: Artist,
    @SerialName("@attr")
    val attr: Attr,
    @SerialName("duration")
    val duration: Int,
    @SerialName("url")
    val url: String,
    @SerialName("name")
    val name: String,
    @SerialName("streamable")
    val streamable: Streamable
)
package com.mikef.lastfm.network.data.artist


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// TODO: Bring data models "together"
@Serializable
data class Artist(
    @SerialName("name")
    val name: String,
    @SerialName("listeners")
    val listeners: String,
    @SerialName("mbid")
    val mbid: String? = null,
    @SerialName("url")
    val url: String,
    @SerialName("streamable")
    val streamable: String,
    @SerialName("image")
    val image: List<Image>
)
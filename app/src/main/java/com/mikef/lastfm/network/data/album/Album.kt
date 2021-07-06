package com.mikef.lastfm.network.data.album


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Album(
    @SerialName("listeners")
    val listeners: String? = null,
    @SerialName("playcount")
    val playcount: String,
    @SerialName("wiki")
    val wiki: Wiki? = null,
    @SerialName("tracks")
    val tracks: Tracks? = null,
    @SerialName("image")
    val image: List<Image>,
    @SerialName("url")
    val url: String? = null,
    @SerialName("artist")
    val artist: String,
    @SerialName("name")
    val name: String,
    @SerialName("mbid")
    val mbid: String? = null
)
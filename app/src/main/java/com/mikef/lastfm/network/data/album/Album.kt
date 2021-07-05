package com.mikef.lastfm.network.data.album


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Album(
    @SerialName("listeners")
    val listeners: String,
    @SerialName("playcount")
    val playcount: String,
    @SerialName("wiki")
    val wiki: Wiki,
    @SerialName("tracks")
    val tracks: Tracks,
    @SerialName("image")
    val image: List<Image>,
    @SerialName("tags")
    val tags: Tags,
    @SerialName("url")
    val url: String,
    @SerialName("artist")
    val artist: String,
    @SerialName("name")
    val name: String,
    @SerialName("mbid")
    val mbid: String? = null
)
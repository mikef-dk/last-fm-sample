package com.mikef.lastfm.network.artistAlbum


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Album(
    @SerialName("name")
    val name: String,
    @SerialName("playcount")
    val playcount: Int,
    @SerialName("mbid")
    val mbid: String,
    @SerialName("url")
    val url: String,
    @SerialName("artist")
    val artist: Artist,
    @SerialName("image")
    val image: List<Image>
)
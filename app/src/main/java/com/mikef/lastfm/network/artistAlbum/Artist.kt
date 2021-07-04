package com.mikef.lastfm.network.artistAlbum


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Artist(
    @SerialName("name")
    val name: String,
    @SerialName("mbid")
    val mbid: String,
    @SerialName("url")
    val url: String
)
package com.mikef.lastfm.network.data.artistAlbum

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ArtistAlbum(
    @SerialName("name")
    val name: String,
    @SerialName("playcount")
    val playcount: Int,
    @SerialName("mbid")
    val mbid: String? = null,
    @SerialName("url")
    val url: String,
    @SerialName("artist")
    val artist: Artist,
    @SerialName("image")
    val image: List<Image>
)
package com.mikef.lastfm.network.artistAlbum


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Image(
    @SerialName("#text")
    val text: String,
    @SerialName("size")
    val size: String
)
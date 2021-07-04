package com.mikef.lastfm.network.artistAlbum


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Topalbums(
    @SerialName("album")
    val album: List<Album>,
    @SerialName("@attr")
    val attr: Attr
)
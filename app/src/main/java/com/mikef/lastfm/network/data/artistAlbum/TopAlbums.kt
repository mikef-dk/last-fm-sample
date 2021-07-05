package com.mikef.lastfm.network.data.artistAlbum


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TopAlbums(
    @SerialName("album")
    val artistAlbum: List<ArtistAlbum>,
    @SerialName("@attr")
    val attr: Attr
)
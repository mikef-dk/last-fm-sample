package com.mikef.lastfm.network.data.artistAlbum


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TopAlbumResponse(
    @SerialName("topalbums")
    val topAlbums: TopAlbums
)
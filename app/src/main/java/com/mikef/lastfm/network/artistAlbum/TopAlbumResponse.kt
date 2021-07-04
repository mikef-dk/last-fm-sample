package com.mikef.lastfm.network.artistAlbum


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TopAlbumResponse(
    @SerialName("topalbums")
    val topalbums: Topalbums
)
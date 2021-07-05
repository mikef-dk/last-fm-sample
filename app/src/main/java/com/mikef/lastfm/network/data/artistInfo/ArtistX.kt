package com.mikef.lastfm.network.data.artistInfo


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ArtistX(
    @SerialName("url")
    val url: String,
    @SerialName("name")
    val name: String,
    @SerialName("image")
    val image: List<ImageX>
)
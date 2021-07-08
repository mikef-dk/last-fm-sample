package com.mikef.lastfm.network.data.artistInfo


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Artist(
    @SerialName("stats")
    val stats: Stats,
    @SerialName("mbid")
    val mbid: String? = null,
    @SerialName("image")
    val image: List<Image>,
    @SerialName("url")
    val url: String,
    @SerialName("name")
    val name: String,
)
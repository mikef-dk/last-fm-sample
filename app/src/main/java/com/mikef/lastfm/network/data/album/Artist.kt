package com.mikef.lastfm.network.data.album


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Artist(
    @SerialName("url")
    val url: String,
    @SerialName("name")
    val name: String,
    @SerialName("mbid")
    val mbid: String? = null
)
package com.mikef.lastfm.network.data.artistInfo


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Artist(
    @SerialName("bio")
    val bio: Bio,
    @SerialName("ontour")
    val ontour: Int,
    @SerialName("stats")
    val stats: Stats,
    @SerialName("mbid")
    val mbid: String? = null,
    @SerialName("image")
    val image: List<Image>,
    @SerialName("similar")
    val similar: Similar,
    @SerialName("url")
    val url: String,
    @SerialName("tags")
    val tags: Tags,
    @SerialName("name")
    val name: String,
    @SerialName("streamable")
    val streamable: String
)
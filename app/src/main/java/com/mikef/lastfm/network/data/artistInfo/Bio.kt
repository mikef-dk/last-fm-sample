package com.mikef.lastfm.network.data.artistInfo


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Bio(
    @SerialName("links")
    val links: Links,
    @SerialName("content")
    val content: String,
    @SerialName("published")
    val published: String,
    @SerialName("summary")
    val summary: String
)
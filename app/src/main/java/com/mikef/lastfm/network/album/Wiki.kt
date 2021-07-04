package com.mikef.lastfm.network.album


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Wiki(
    @SerialName("published")
    val published: String,
    @SerialName("content")
    val content: String,
    @SerialName("summary")
    val summary: String
)
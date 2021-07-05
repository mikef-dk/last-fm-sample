package com.mikef.lastfm.network.data.artistInfo


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Tag(
    @SerialName("name")
    val name: String,
    @SerialName("url")
    val url: String
)
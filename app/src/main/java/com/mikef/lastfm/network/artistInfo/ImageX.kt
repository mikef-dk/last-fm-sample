package com.mikef.lastfm.network.artistInfo


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ImageX(
    @SerialName("size")
    val size: String,
    @SerialName("#text")
    val text: String
)
package com.mikef.lastfm.network.album


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Image(
    @SerialName("size")
    val size: String,
    @SerialName("#text")
    val text: String
)
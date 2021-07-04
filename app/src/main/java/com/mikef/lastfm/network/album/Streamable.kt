package com.mikef.lastfm.network.album


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Streamable(
    @SerialName("fulltrack")
    val fulltrack: String,
    @SerialName("#text")
    val text: String
)
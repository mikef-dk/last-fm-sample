package com.mikef.lastfm.network.artist


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Attr(
    @SerialName("for")
    val forX: String
)
package com.mikef.lastfm.network.data.artist


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Attr(
    @SerialName("for")
    val forX: String
)
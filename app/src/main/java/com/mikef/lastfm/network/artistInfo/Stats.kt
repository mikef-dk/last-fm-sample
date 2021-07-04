package com.mikef.lastfm.network.artistInfo


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Stats(
    @SerialName("playcount")
    val playcount: Int,
    @SerialName("listeners")
    val listeners: Int
)
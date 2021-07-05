package com.mikef.lastfm.network.data.artistInfo


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Links(
    @SerialName("link")
    val link: Link
)
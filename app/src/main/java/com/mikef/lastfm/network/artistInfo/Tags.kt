package com.mikef.lastfm.network.artistInfo


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Tags(
    @SerialName("tag")
    val tag: List<Tag>
)
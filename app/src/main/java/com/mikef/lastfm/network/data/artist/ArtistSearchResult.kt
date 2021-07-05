package com.mikef.lastfm.network.data.artist


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ArtistSearchResult(
    @SerialName("results")
    val results: Results
)
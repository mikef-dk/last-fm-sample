package com.mikef.lastfm.network.artistAlbum


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Attr(
    @SerialName("artist")
    val artist: String,
    @SerialName("page")
    val page: String,
    @SerialName("perPage")
    val perPage: String,
    @SerialName("totalPages")
    val totalPages: String,
    @SerialName("total")
    val total: String
)
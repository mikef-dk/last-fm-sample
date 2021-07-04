package com.mikef.lastfm.network.artist


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OpensearchQuery(
    @SerialName("#text")
    val text: String,
    @SerialName("role")
    val role: String,
    @SerialName("searchTerms")
    val searchTerms: String,
    @SerialName("startPage")
    val startPage: String
)
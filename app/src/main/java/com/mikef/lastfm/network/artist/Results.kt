package com.mikef.lastfm.network.artist


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Results(
    @SerialName("opensearch:Query")
    val opensearchQuery: OpensearchQuery,
    @SerialName("opensearch:totalResults")
    val opensearchTotalResults: String,
    @SerialName("opensearch:startIndex")
    val opensearchStartIndex: String,
    @SerialName("opensearch:itemsPerPage")
    val opensearchItemsPerPage: String,
    @SerialName("artistmatches")
    val artistMatches: ArtistMatches,
    @SerialName("@attr")
    val attr: Attr
)
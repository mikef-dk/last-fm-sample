package com.mikef.lastfm.network.data.album


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Track(
    @SerialName("artist")
    val artist: Artist,
    @SerialName("@attr")
    val attr: Attr,
    @SerialName("duration")
    val duration: Int,
    @SerialName("url")
    val url: String,
    @SerialName("name")
    val name: String,
    @SerialName("streamable")
    val streamable: Streamable? = null
) {

    fun getDurationInMinutes(): String {
        val minutes = duration / 60
        val seconds = duration % 60
        // TODO: Proper format
        return "$minutes:$seconds"
//        return String.format("%02d:%02d", minutes, seconds)
//        return "%d:%02d".format(minutes, seconds)
    }

}
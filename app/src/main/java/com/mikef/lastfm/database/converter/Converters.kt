package com.mikef.lastfm.database.converter

import androidx.room.TypeConverter
import com.mikef.lastfm.network.data.album.Album
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class Converters {

    @TypeConverter
    fun stringToAlbum(value: String): Album {
        return Json.decodeFromString(value)
    }

    @TypeConverter
    fun albumToString(value: Album): String {
        return Json.encodeToString(value)
    }

}
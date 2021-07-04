package com.mikef.lastfm.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.mikef.lastfm.network.album.Album

@Entity(primaryKeys = ["artist_name", "album_name"], tableName = "album_table")
class AlbumEntity(
    @ColumnInfo(name = "artist_name") val artistName: String,
    @ColumnInfo(name = "album_name") val albumName: String,
    @ColumnInfo(name = "album_info") val album: Album,
)
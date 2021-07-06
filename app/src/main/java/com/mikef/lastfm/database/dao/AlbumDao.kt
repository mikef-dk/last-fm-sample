package com.mikef.lastfm.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.mikef.lastfm.database.entity.AlbumEntity

@Dao
interface AlbumDao {

    @Query("SELECT * from album_table")
    suspend fun getAlbums(): List<AlbumEntity>

    @Query("SELECT * from album_table WHERE artist_name = :artistName AND album_name = :albumName")
    suspend fun getAlbum(artistName: String, albumName: String): AlbumEntity?

    @Insert
    suspend fun insert(album: AlbumEntity)

    @Query("DELETE FROM album_table WHERE artist_name = :artistName AND album_name = :albumName")
    suspend fun delete(artistName: String, albumName: String) : Int

}
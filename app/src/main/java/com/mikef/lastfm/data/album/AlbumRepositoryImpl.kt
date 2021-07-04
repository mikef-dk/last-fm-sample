package com.mikef.lastfm.data.album

import com.mikef.lastfm.database.dao.AlbumDao
import com.mikef.lastfm.database.entity.AlbumEntity
import com.mikef.lastfm.network.album.Album

class AlbumRepositoryImpl(
    private val albumDao: AlbumDao,
    private val albumService: AlbumService
) : AlbumRepository {

    override suspend fun getAlbumInfo(artistName: String, albumName: String): Album {
        val albumEntity = albumDao.getAlbum(artistName, albumName)
        return albumEntity?.album
            ?: albumService.fetchAlbumInfo(artistName = artistName, album = albumName).album
    }

    override suspend fun saveAlbum(album: Album) {
        albumDao.insert(
            AlbumEntity(
                artistName = album.artist,
                albumName = album.name,
                album = album
            )
        )
    }

    override suspend fun deleteAlbum(album: Album) {
        albumDao.delete(artistName = album.artist, albumName = album.name)
    }
}
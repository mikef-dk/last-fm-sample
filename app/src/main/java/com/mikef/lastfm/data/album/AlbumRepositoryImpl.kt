package com.mikef.lastfm.data.album

import com.mikef.lastfm.database.dao.AlbumDao
import com.mikef.lastfm.database.entity.AlbumEntity
import com.mikef.lastfm.data.RepoResult
import com.mikef.lastfm.network.data.album.Album
import timber.log.Timber

class AlbumRepositoryImpl(
    private val albumDao: AlbumDao,
    private val albumService: AlbumService
) : AlbumRepository {

    data class AlbumResponse(
        val album: Album,
        val saved: Boolean
    )

    override suspend fun getAlbumInfo(
        artistName: String,
        albumName: String
    ): RepoResult<AlbumResponse> {
        val albumEntity = albumDao.getAlbum(artistName, albumName)

        albumEntity?.album?.let {
            RepoResult.Success(AlbumResponse(album = it, saved = true))
        }

        val album = albumEntity?.album
        return if (album != null) {
            RepoResult.Success(AlbumResponse(album = album, saved = true))
        } else {
            fetchAlbumInfo(artistName = artistName, albumName = albumName)
        }
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

    private suspend fun fetchAlbumInfo(
        artistName: String,
        albumName: String
    ): RepoResult<AlbumResponse> {
        return try {
            RepoResult.Success(
                AlbumResponse(
                    album = albumService.fetchAlbumInfo(
                        artistName = artistName,
                        album = albumName
                    ).album,
                    saved = false
                )
            )
        } catch (e: Exception) {
            Timber.e("Failure while fetching album: ${e.toString()}")
            RepoResult.Failure(e)
        }
    }

}
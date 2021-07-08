package com.mikef.lastfm.pages.artist.adapter

import com.mikef.lastfm.R
import com.mikef.lastfm.network.data.artistAlbum.ArtistAlbum
import com.mikef.lastfm.pages.artist.adapter.delegates.ArtistAlbumDelegate
import com.mikef.lastfm.pages.overview.adapter.delegates.TitleDelegate
import com.mikef.lastfm.shared.adapter.AdapterData
import com.mikef.lastfm.shared.resprovider.ResProvider

class ArtistInfoDataManager(resProvider: ResProvider) : ResProvider by resProvider {

    fun buildList(artistAlbums: List<ArtistAlbum>): List<AdapterData<*>> {
        return mutableListOf<AdapterData<*>>().apply {
            add(
                TitleDelegate.MainTitleData(
                    title = getString(R.string.artist_info_top_albums_title)
                )
            )
            artistAlbums.forEach { album ->
                add(
                    ArtistAlbumDelegate.ArtistAlbumData(
                        imageUrl = album.image.last().text,
                        albumName = album.name,
                        playCount = album.playcount
                    )
                )
            }
        }
    }

}
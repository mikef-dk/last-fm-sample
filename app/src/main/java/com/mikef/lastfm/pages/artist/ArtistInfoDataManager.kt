package com.mikef.lastfm.pages.artist

import com.mikef.lastfm.network.data.artistAlbum.ArtistAlbum
import com.mikef.lastfm.pages.artist.adapter.delegates.ArtistAlbumDelegate
import com.mikef.lastfm.pages.main.adapter.delegates.TitleDelegate
import com.mikef.lastfm.shared.adapter.AdapterData

class ArtistInfoDataManager() {

    fun buildList(artistAlbums: List<ArtistAlbum>): List<AdapterData<*>> {
        return mutableListOf<AdapterData<*>>().apply {
            add(
                TitleDelegate.MainTitleData(title = "Top-Albums")
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
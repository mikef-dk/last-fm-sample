package com.mikef.lastfm.pages.overview.adapter

import com.mikef.lastfm.network.data.album.Album
import com.mikef.lastfm.pages.overview.adapter.delegates.AlbumDelegate
import com.mikef.lastfm.shared.adapter.AdapterData

class AlbumCollectionDataManager {

    fun buildList(list: List<Album>): List<AdapterData<*>> {
        return mutableListOf<AdapterData<*>>().apply {
            list.forEach { album ->
                add(
                    AlbumDelegate.AlbumData(
                        imageUrl = album.image.lastOrNull()?.text,
                        albumName = album.name,
                        artist = album.artist
                    )
                )
            }
        }
    }

}
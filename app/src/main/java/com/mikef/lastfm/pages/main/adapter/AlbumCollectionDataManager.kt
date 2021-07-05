package com.mikef.lastfm.pages.main.adapter

import com.mikef.lastfm.network.data.album.Album
import com.mikef.lastfm.pages.main.adapter.delegates.AlbumDelegate
import com.mikef.lastfm.shared.adapter.AdapterData

class AlbumCollectionDataManager {

    fun buildList(list: List<Album>): List<AdapterData<*>> {
        return mutableListOf<AdapterData<*>>().apply {
            list.forEach { album ->
                add(
                    AlbumDelegate.AlbumData(
                        imageUrl = album.image.last().text,
                        albumName = album.name,
                        artist = album.artist
                    )
                )
            }
        }
    }

}
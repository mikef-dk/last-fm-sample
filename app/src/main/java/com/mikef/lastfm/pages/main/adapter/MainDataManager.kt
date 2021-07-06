package com.mikef.lastfm.pages.main.adapter

import com.mikef.lastfm.network.data.album.Album
import com.mikef.lastfm.pages.main.adapter.delegates.AlbumCollectionDelegate
import com.mikef.lastfm.pages.main.adapter.delegates.TitleDelegate
import com.mikef.lastfm.shared.adapter.AdapterData

class MainDataManager(private val albumCollectionDataManager: AlbumCollectionDataManager) {

    fun buildList(albums: List<Album>?): List<AdapterData<*>> {
        return mutableListOf<AdapterData<*>>().apply {
            val groupedList = albums?.groupBy { it.artist }
            groupedList?.forEach { (artist, albums) ->
                add(TitleDelegate.MainTitleData(title = artist))
                add(
                    AlbumCollectionDelegate.AlbumCollectionData(
                        albumCollectionDataManager.buildList(albums)
                    )
                )
            }
        }
    }

}
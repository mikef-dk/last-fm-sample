package com.mikef.lastfm.pages.overview.adapter

import com.mikef.lastfm.network.data.album.Album
import com.mikef.lastfm.pages.overview.adapter.delegates.AlbumCollectionDelegate
import com.mikef.lastfm.pages.overview.adapter.delegates.TitleDelegate
import com.mikef.lastfm.shared.adapter.AdapterData

class OverviewDataManager(private val albumCollectionDataManager: AlbumCollectionDataManager) {

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
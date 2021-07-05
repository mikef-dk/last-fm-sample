package com.mikef.lastfm.pages.search

import com.mikef.lastfm.network.data.artist.Artist
import com.mikef.lastfm.pages.search.adapter.delegates.NoSearchResultDelegate
import com.mikef.lastfm.pages.search.adapter.delegates.SearchResultDelegate
import com.mikef.lastfm.shared.adapter.AdapterData

class SearchDataManager() {

    fun buildList(query: String, list: List<Artist>): List<AdapterData<*>> {
        return mutableListOf<AdapterData<*>>().apply {
            if (list.isEmpty()) {
                add(
                    NoSearchResultDelegate.NoSearchResultData(
                        // TODO
                        text = ""
                    )
                )
            } else {
                list.forEach { artist ->
                    add(
                        SearchResultDelegate.SearchResultData(
                            artistName = artist.name,
                            artistImageUrl = artist.image.last().text
                        )
                    )
                }
            }
        }
    }

}
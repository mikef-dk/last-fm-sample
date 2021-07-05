package com.mikef.lastfm.pages.search

import com.mikef.lastfm.R
import com.mikef.lastfm.network.artist.Artist
import com.mikef.lastfm.pages.search.adapter.delegates.NoSearchResultDelegate
import com.mikef.lastfm.pages.search.adapter.delegates.SearchResultDelegate
import com.mikef.lastfm.shared.adapter.AdapterData
import com.mikef.lastfm.shared.resprovider.ResProvider

class SearchDataManager(private val resProvider: ResProvider) {

    fun buildList(query: String, list: List<Artist>): List<AdapterData<*>> {
        return mutableListOf<AdapterData<*>>().apply {
            if (list.isEmpty()) {
                add(
                    NoSearchResultDelegate.NoSearchResultData(
                        text = resProvider.getString(R.string.search_no_result, query)
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
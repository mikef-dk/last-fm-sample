package com.mikef.lastfm.pages.search.adapter

import com.mikef.lastfm.pages.search.adapter.delegates.NoSearchResultDelegate
import com.mikef.lastfm.pages.search.adapter.delegates.SearchResultDelegate
import com.mikef.lastfm.shared.adapter.BaseDelegateAdapter

class SearchAdapter(listener: SearchResultDelegate.Listener) : BaseDelegateAdapter() {

    init {
        delegatesManager.apply {
            addDelegate(NoSearchResultDelegate.create())
            addDelegate(SearchResultDelegate.create(listener))
        }
    }

}
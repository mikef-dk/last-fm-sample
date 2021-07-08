package com.mikef.lastfm.pages.overview.adapter

import com.mikef.lastfm.pages.overview.adapter.delegates.AlbumCollectionDelegate
import com.mikef.lastfm.pages.overview.adapter.delegates.AlbumDelegate
import com.mikef.lastfm.pages.overview.adapter.delegates.TitleDelegate
import com.mikef.lastfm.shared.adapter.BaseDelegateAdapter

class OverviewAdapter(private val listener: AlbumDelegate.Listener) : BaseDelegateAdapter() {

    init {
        delegatesManager.apply {
            addDelegate(TitleDelegate.create())
            addDelegate(AlbumCollectionDelegate.create(listener))
        }
    }

}
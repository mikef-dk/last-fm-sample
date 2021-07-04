package com.mikef.lastfm.pages.main.adapter

import com.mikef.lastfm.pages.main.adapter.delegates.AlbumCollectionDelegate
import com.mikef.lastfm.pages.main.adapter.delegates.AlbumDelegate
import com.mikef.lastfm.pages.main.adapter.delegates.TitleDelegate
import com.mikef.lastfm.shared.adapter.BaseDelegateAdapter

class MainAdapter(private val listener: AlbumDelegate.Listener) : BaseDelegateAdapter() {

    init {
        delegatesManager.apply {
            addDelegate(TitleDelegate.create())
            addDelegate(AlbumCollectionDelegate.create(listener))
        }
    }

}
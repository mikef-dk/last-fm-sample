package com.mikef.lastfm.pages.main.adapter

import com.mikef.lastfm.pages.main.adapter.delegates.AlbumDelegate
import com.mikef.lastfm.shared.adapter.BaseDelegateAdapter

class AlbumCollectionAdapter(listener: AlbumDelegate.Listener) : BaseDelegateAdapter() {

    init {
        delegatesManager.apply {
            addDelegate(AlbumDelegate.create(listener))
        }
    }

}
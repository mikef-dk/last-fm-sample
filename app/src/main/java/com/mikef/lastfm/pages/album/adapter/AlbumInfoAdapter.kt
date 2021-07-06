package com.mikef.lastfm.pages.album.adapter

import com.mikef.lastfm.pages.album.adapter.delegates.TrackDelegate
import com.mikef.lastfm.shared.adapter.BaseDelegateAdapter

class AlbumInfoAdapter : BaseDelegateAdapter() {

    init {
        delegatesManager.apply {
            addDelegate(TrackDelegate.create())
        }
    }

}
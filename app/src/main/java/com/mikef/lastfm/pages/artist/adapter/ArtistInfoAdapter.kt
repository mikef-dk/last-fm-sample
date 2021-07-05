package com.mikef.lastfm.pages.artist.adapter

import com.mikef.lastfm.pages.artist.adapter.delegates.ArtistAlbumDelegate
import com.mikef.lastfm.pages.main.adapter.delegates.TitleDelegate
import com.mikef.lastfm.shared.adapter.BaseDelegateAdapter

class ArtistInfoAdapter(albumListener: ArtistAlbumDelegate.Listener) : BaseDelegateAdapter() {

    init {
        delegatesManager.apply {
            addDelegate(TitleDelegate.create())
            addDelegate(ArtistAlbumDelegate.create(albumListener))
        }
    }

}
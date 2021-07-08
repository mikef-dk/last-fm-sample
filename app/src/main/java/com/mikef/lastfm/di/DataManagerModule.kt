package com.mikef.lastfm.di

import com.mikef.lastfm.pages.album.adapter.AlbumInfoDataManager
import com.mikef.lastfm.pages.artist.adapter.ArtistInfoDataManager
import com.mikef.lastfm.pages.overview.adapter.AlbumCollectionDataManager
import com.mikef.lastfm.pages.overview.adapter.OverviewDataManager
import com.mikef.lastfm.pages.search.adapter.SearchDataManager
import org.koin.dsl.module

val dataManagerModule = module {

    single {
        AlbumCollectionDataManager()
    }

    single {
        OverviewDataManager(albumCollectionDataManager = get())
    }

    single {
        SearchDataManager(resProvider = get())
    }

    single {
        ArtistInfoDataManager(resProvider = get())
    }

    single {
        AlbumInfoDataManager()
    }

}
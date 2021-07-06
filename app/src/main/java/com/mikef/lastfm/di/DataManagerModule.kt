package com.mikef.lastfm.di

import com.mikef.lastfm.pages.album.AlbumInfoDataManager
import com.mikef.lastfm.pages.artist.ArtistInfoDataManager
import com.mikef.lastfm.pages.main.adapter.AlbumCollectionDataManager
import com.mikef.lastfm.pages.main.adapter.MainDataManager
import com.mikef.lastfm.pages.search.SearchDataManager
import org.koin.dsl.module

val dataManagerModule = module {

    single {
        AlbumCollectionDataManager()
    }

    single {
        MainDataManager(albumCollectionDataManager = get())
    }

    single {
        SearchDataManager()
    }

    single {
        ArtistInfoDataManager()
    }

    single {
        AlbumInfoDataManager()
    }

}
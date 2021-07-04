package com.mikef.lastfm.di

import com.mikef.lastfm.pages.main.adapter.AlbumCollectionDataManager
import com.mikef.lastfm.pages.main.adapter.MainDataManager
import com.mikef.lastfm.shared.flipper.FlipperConfig
import com.mikef.lastfm.shared.flipper.FlipperConfigImpl
import org.koin.dsl.module

val baseModule = module {

    single<FlipperConfig> {
        FlipperConfigImpl()
    }

    single {
        AlbumCollectionDataManager()
    }

    single {
        MainDataManager(albumCollectionDataManager = get())
    }

}

package com.mikef.lastfm.di

import com.mikef.lastfm.database.LastFmDatabase
import org.koin.dsl.module

val daoModule = module {

    single {
        LastFmDatabase.getInstance(
            context = get()
        )
    }

    single { get<LastFmDatabase>().albumDao() }

}

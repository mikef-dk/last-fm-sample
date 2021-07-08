package com.mikef.lastfm.di

import com.mikef.lastfm.shared.flipper.FlipperConfig
import com.mikef.lastfm.shared.flipper.FlipperConfigImpl
import com.mikef.lastfm.shared.resprovider.ResProvider
import com.mikef.lastfm.shared.resprovider.ResProviderImpl
import org.koin.dsl.module

val baseModule = module {

    single<FlipperConfig> {
        FlipperConfigImpl()
    }

    single<ResProvider> {
        ResProviderImpl(context = get())
    }

}

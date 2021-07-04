package com.mikef.lastfm

import android.app.Application
import com.mikef.lastfm.di.*
import com.mikef.lastfm.shared.flipper.FlipperConfig
import org.koin.android.ext.android.get
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

@Suppress("unused")
class LastFmApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initTimber()
        initKoin()
        initFlipper()
    }

    ///////////////////////////////////////////////////////////////////////////
    // Private methods
    ///////////////////////////////////////////////////////////////////////////

    private fun initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@LastFmApplication)
            modules(
                listOf(
                    baseModule,
                    daoModule,
                    navigationModule,
                    networkModule,
                    repositoryModule,
                    viewModelModule
                )
            )
        }
    }

    private fun initFlipper() {
        get<FlipperConfig>().init(this)
    }

}
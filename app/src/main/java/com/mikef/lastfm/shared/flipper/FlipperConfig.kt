package com.mikef.lastfm.shared.flipper

import android.app.Application
import okhttp3.Interceptor

interface FlipperConfig {

    fun init(application: Application)

    fun getInterceptor(): Interceptor?

}
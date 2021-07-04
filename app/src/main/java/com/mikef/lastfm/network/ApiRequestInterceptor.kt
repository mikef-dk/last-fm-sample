package com.mikef.lastfm.network

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import java.io.IOException


class ApiRequestInterceptor : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val original: Request = chain.request()
        val originalHttpUrl = original.url

        val url = originalHttpUrl.newBuilder()
            .addQueryParameter("api_key", ApiConfig.API_KEY)
            .addQueryParameter("format", "json")
            .build()

        // Request customization: add request headers
        val requestBuilder = original.newBuilder().url(url)
        return chain.proceed(requestBuilder.build())
    }

}
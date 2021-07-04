package com.mikef.lastfm.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.mikef.lastfm.data.album.AlbumService
import com.mikef.lastfm.data.artist.ArtistService
import com.mikef.lastfm.data.search.SearchService
import com.mikef.lastfm.network.ApiConfig
import com.mikef.lastfm.network.ApiRequestInterceptor
import com.mikef.lastfm.shared.flipper.FlipperConfig
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit

val networkModule = module {

    factory<HttpLoggingInterceptor?> {
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    factory {
        ApiRequestInterceptor()
    }

    single {
        OkHttpClient().newBuilder().apply {
            get<FlipperConfig>().getInterceptor()?.also {
                addInterceptor(it)
                addInterceptor(get<ApiRequestInterceptor>())
                addInterceptor(get<HttpLoggingInterceptor>())
            }
        }.build()
    }

    single {
        val contentType = "application/json".toMediaType()
        Retrofit.Builder()
            .client(get())
            .baseUrl(ApiConfig.BASE_URL)
            .addConverterFactory(Json.asConverterFactory(contentType))
            .build()
    }

    single {
        get<Retrofit>().create(SearchService::class.java)
    }

    single {
        get<Retrofit>().create(AlbumService::class.java)
    }

    single {
        get<Retrofit>().create(ArtistService::class.java)
    }

}
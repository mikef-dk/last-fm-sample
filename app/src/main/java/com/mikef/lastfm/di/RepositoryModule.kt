package com.mikef.lastfm.di

import com.mikef.lastfm.data.album.AlbumRepository
import com.mikef.lastfm.data.album.AlbumRepositoryImpl
import com.mikef.lastfm.data.artist.ArtistRepository
import com.mikef.lastfm.data.artist.ArtistRepositoryImpl
import com.mikef.lastfm.data.search.SearchRepository
import com.mikef.lastfm.data.search.SearchRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {

    single<SearchRepository> {
        SearchRepositoryImpl(
            searchService = get()
        )
    }

    single<ArtistRepository> {
        ArtistRepositoryImpl(
            artistService = get()
        )
    }

    single<AlbumRepository> {
        AlbumRepositoryImpl(
            albumDao = get(),
            albumService = get()
        )
    }

}

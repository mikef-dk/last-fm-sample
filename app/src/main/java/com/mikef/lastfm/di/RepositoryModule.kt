package com.mikef.lastfm.di

import com.mikef.lastfm.repository.album.AlbumRepository
import com.mikef.lastfm.repository.album.AlbumRepositoryImpl
import com.mikef.lastfm.repository.artist.ArtistRepository
import com.mikef.lastfm.repository.artist.ArtistRepositoryImpl
import com.mikef.lastfm.repository.search.SearchRepository
import com.mikef.lastfm.repository.search.SearchRepositoryImpl
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

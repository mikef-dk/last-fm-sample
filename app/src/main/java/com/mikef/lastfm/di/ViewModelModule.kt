package com.mikef.lastfm.di

import com.mikef.lastfm.pages.album.AlbumInfoFragment
import com.mikef.lastfm.pages.album.AlbumInfoViewModel
import com.mikef.lastfm.pages.artist.ArtistInfoFragment
import com.mikef.lastfm.pages.artist.ArtistInfoViewModel
import com.mikef.lastfm.pages.main.MainFragment
import com.mikef.lastfm.pages.main.MainViewModel
import com.mikef.lastfm.pages.search.SearchFragment
import com.mikef.lastfm.pages.search.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val viewModelModule = module {

    scope(named<MainFragment>()) {
        viewModel {
            MainViewModel(
                dataManager = get(),
                albumDao = get()
            )
        }
    }

    scope(named<SearchFragment>()) {
        viewModel {
            SearchViewModel(
                dataManager = get(),
                searchRepository = get()
            )
        }
    }

    scope(named<ArtistInfoFragment>()) {
        viewModel {
            ArtistInfoViewModel(
                artistRepository = get(),
                dataManager = get()
            )
        }
    }

    scope(named<AlbumInfoFragment>()) {
        viewModel {
            AlbumInfoViewModel(albumRepository = get())
        }
    }

}

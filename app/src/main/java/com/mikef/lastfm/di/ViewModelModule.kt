package com.mikef.lastfm.di

import com.mikef.lastfm.pages.main.MainFragment
import com.mikef.lastfm.pages.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val viewModelModule = module {

    scope(named<MainFragment>()) {
        viewModel {
            MainViewModel(
                searchRepository = get()
            )
        }
    }

}

package com.mikef.lastfm.di

import com.mikef.lastfm.MainActivity
import com.mikef.lastfm.shared.navigation.NavigationDelegate
import com.mikef.lastfm.shared.navigation.NavigationDelegateImpl
import org.koin.core.qualifier.named
import org.koin.dsl.module

val navigationModule = module {

    scope(named<MainActivity>()) {
        scoped<NavigationDelegate> { (activity: MainActivity) ->
            NavigationDelegateImpl(activity)
        }
    }

}
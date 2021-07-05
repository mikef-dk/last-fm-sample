package com.mikef.lastfm.shared.navigation

interface NavigationDelegate {

    fun initialize()

    fun navigateToSearch()

    fun navigateToArtistInfo(artistName: String)


}
package com.mikef.lastfm.shared.navigation

interface NavigationDelegate {

    fun initialize()

    fun navigateToSearch()

    fun navigateToArtistInfo(artistName: String)

    fun navigateToAlbumInfo(artistName: String, albumName: String)

    fun goBack()

}
package com.mikef.lastfm.shared.navigation

import android.app.Activity
import androidx.navigation.findNavController
import com.mikef.lastfm.R
import com.mikef.lastfm.pages.album.AlbumInfoFragmentArgs
import com.mikef.lastfm.pages.artist.ArtistInfoFragmentArgs

class NavigationDelegateImpl(activity: Activity) : NavigationDelegate {

    private val navController = activity.findNavController(R.id.navHostFragment)

    override fun initialize() {
        val graph = navController.navInflater.inflate(R.navigation.mobile_navigation)
        navController.graph = graph
    }

    override fun navigateToSearch() {
        navController.navigate(R.id.action_navigation_overview_to_search)
    }

    override fun navigateToArtistInfo(artistName: String) {
        navController.navigate(
            R.id.action_navigation_search_to_artist_info,
            ArtistInfoFragmentArgs(
                artistName = artistName
            ).toBundle()
        )
    }

    override fun navigateToAlbumInfo(artistName: String, albumName: String) {
        navController.navigate(
            R.id.action_navigation_to_album_info,
            AlbumInfoFragmentArgs(
                artistName = artistName,
                albumName = albumName
            ).toBundle()
        )
    }

    override fun goBack() {
        navController.popBackStack()
    }

}
package com.mikef.lastfm.shared.navigation

import android.app.Activity
import androidx.navigation.findNavController
import com.mikef.lastfm.R

class NavigationDelegateImpl(activity: Activity) : NavigationDelegate {

    private val navController = activity.findNavController(R.id.navHostFragment)

    override fun initialize() {
        val graph = navController.navInflater.inflate(R.navigation.mobile_navigation)
        navController.graph = graph
    }

}
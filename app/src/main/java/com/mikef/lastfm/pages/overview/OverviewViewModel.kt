package com.mikef.lastfm.pages.overview

import androidx.lifecycle.viewModelScope
import com.mikef.lastfm.database.dao.AlbumDao
import com.mikef.lastfm.pages.overview.adapter.OverviewDataManager
import com.mikef.lastfm.shared.BaseViewModel
import com.mikef.lastfm.shared.adapter.AdapterData
import com.mikef.lastfm.shared.navigation.NavigationDelegate
import kotlinx.coroutines.launch

class OverviewViewModel(
    private val dataManager: OverviewDataManager,
    private val albumDao: AlbumDao
) : BaseViewModel<List<AdapterData<*>>>() {

    fun onViewCreated() {
        viewModelScope.launch {
            val albums = albumDao.getAlbums()
            if (albums.isEmpty()) {
                mutableViewState.value = dataManager.buildList(null)
            } else {
                mutableViewState.value = dataManager.buildList(albums.map { it.album })
            }
        }
    }

    fun onAlbumClicked(
        navigationDelegate: NavigationDelegate,
        artistName: String,
        albumName: String
    ) {
        navigationDelegate.navigateToAlbumInfo(artistName, albumName)
    }

    fun onSearchClicked(navigationDelegate: NavigationDelegate) {
        navigationDelegate.navigateToSearch()
    }

}
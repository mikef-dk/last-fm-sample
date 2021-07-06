package com.mikef.lastfm.pages.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mikef.lastfm.database.dao.AlbumDao
import com.mikef.lastfm.pages.main.adapter.MainDataManager
import com.mikef.lastfm.shared.adapter.AdapterData
import com.mikef.lastfm.shared.navigation.NavigationDelegate
import kotlinx.coroutines.launch

class MainViewModel(
    private val dataManager: MainDataManager,
    private val albumDao: AlbumDao
) : ViewModel() {

    private val mutableListData: MutableLiveData<List<AdapterData<*>>> = MutableLiveData()
    val listData: LiveData<List<AdapterData<*>>>
        get() = mutableListData

    fun onViewCreated() {
        viewModelScope.launch {
            val albums = albumDao.getAlbums()
            if (albums.isEmpty()) {
                mutableListData.value = dataManager.buildList(null)
            } else {
                mutableListData.value = dataManager.buildList(albums.map { it.album })
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
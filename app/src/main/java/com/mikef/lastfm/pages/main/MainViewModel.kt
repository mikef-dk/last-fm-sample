package com.mikef.lastfm.pages.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mikef.lastfm.data.search.SearchRepository
import kotlinx.coroutines.launch

class MainViewModel(
    private val searchRepository: SearchRepository
) : ViewModel() {

    fun onViewCreated() {
        viewModelScope.launch {
            searchRepository.searchArtist("cher")
        }
    }

}
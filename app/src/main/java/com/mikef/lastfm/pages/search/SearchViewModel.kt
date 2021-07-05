package com.mikef.lastfm.pages.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mikef.lastfm.data.search.SearchRepository
import com.mikef.lastfm.network.ApiResult
import com.mikef.lastfm.network.artist.ArtistSearchResult
import com.mikef.lastfm.shared.ConflatedJob
import com.mikef.lastfm.shared.adapter.AdapterData
import com.mikef.lastfm.shared.navigation.NavigationDelegate
import kotlinx.coroutines.launch

class SearchViewModel(
    private val searchRepository: SearchRepository,
    private val dataManager: SearchDataManager
) : ViewModel() {

    private val mutableListData: MutableLiveData<List<AdapterData<*>>> = MutableLiveData()
    val listData: LiveData<List<AdapterData<*>>>
        get() = mutableListData

    private var searchJob = ConflatedJob()

    fun onSearchQueryChanged(query: String) {
        searchJob += viewModelScope.launch {
            val result = searchRepository.searchArtist(query)
            handleSearchResult(result)
        }
    }

    fun onSearchResultClicked(navigationDelegate: NavigationDelegate, artistName: String) {
        navigationDelegate.navigateToArtistInfo(artistName)
    }

    ///////////////////////////////////////////////////////////////////////////
    // Private methods
    ///////////////////////////////////////////////////////////////////////////

    private fun handleSearchResult(result: ApiResult<ArtistSearchResult>) {
        when (result) {
            is ApiResult.Success -> {
                mutableListData.value = dataManager.buildList(
                    result.value.results.attr.forX,
                    result.value.results.artistMatches.artist
                )
            }
            is ApiResult.Failure -> {
                // TODO: Proper error handling
            }
        }
    }

}
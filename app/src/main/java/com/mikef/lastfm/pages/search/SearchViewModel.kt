package com.mikef.lastfm.pages.search

import androidx.lifecycle.viewModelScope
import com.mikef.lastfm.R
import com.mikef.lastfm.network.data.artist.ArtistSearchResult
import com.mikef.lastfm.repository.RepoResult
import com.mikef.lastfm.repository.search.SearchRepository
import com.mikef.lastfm.shared.BaseViewModel
import com.mikef.lastfm.shared.ConflatedJob
import com.mikef.lastfm.shared.adapter.AdapterData
import com.mikef.lastfm.shared.navigation.NavigationDelegate
import kotlinx.coroutines.launch

class SearchViewModel(
    private val searchRepository: SearchRepository,
    private val dataManager: SearchDataManager
) : BaseViewModel<List<AdapterData<*>>>() {

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

    private fun handleSearchResult(result: RepoResult<ArtistSearchResult>) {
        when (result) {
            is RepoResult.Success -> {
                mutableViewState.value = dataManager.buildList(
                    result.value.results.attr.forX,
                    result.value.results.artistMatches.artist
                )
            }
            is RepoResult.Failure -> {
                mutableError.value = R.string.default_error
            }
        }
    }

}
package com.mikef.lastfm.pages.artist

import androidx.lifecycle.viewModelScope
import com.mikef.lastfm.R
import com.mikef.lastfm.network.data.artistAlbum.TopAlbumResponse
import com.mikef.lastfm.network.data.artistInfo.ArtistInfoResponse
import com.mikef.lastfm.repository.RepoResult
import com.mikef.lastfm.repository.artist.ArtistRepository
import com.mikef.lastfm.shared.BaseViewModel
import com.mikef.lastfm.shared.adapter.AdapterData
import com.mikef.lastfm.shared.navigation.NavigationDelegate
import kotlinx.coroutines.launch

class ArtistInfoViewModel(
    private val artistRepository: ArtistRepository,
    private val dataManager: ArtistInfoDataManager
) : BaseViewModel<ArtistInfoViewModel.ViewState>() {

    private lateinit var artistName: String

    fun onViewCreated(args: ArtistInfoFragmentArgs) {
        artistName = args.artistName

        viewModelScope.launch {
            handleResult(artistRepository.fetchArtistData(artistName))
        }
    }

    fun onAlbumClicked(navigationDelegate: NavigationDelegate, albumName: String) {
        navigationDelegate.navigateToAlbumInfo(artistName, albumName)
    }

    ///////////////////////////////////////////////////////////////////////////
    // Private methods
    ///////////////////////////////////////////////////////////////////////////

    private fun handleResult(result: RepoResult<Pair<ArtistInfoResponse, TopAlbumResponse>>) {
        when (result) {
            is RepoResult.Success -> {
                val (artistResponse, topAlbums) = result.value
                mutableViewState.value =
                    ViewState(
                        artistResponse.artist.name,
                        artistResponse.artist.image.last().text,
                        dataManager.buildList(topAlbums.topAlbums.artistAlbum)
                    )
            }
            is RepoResult.Failure -> {
                mutableError.value = R.string.default_error
            }
        }
    }

    data class ViewState(
        val artistName: String,
        val artistUrl: String,
        val listData: List<AdapterData<*>>
    )

}
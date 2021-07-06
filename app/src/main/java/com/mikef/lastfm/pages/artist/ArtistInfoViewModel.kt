package com.mikef.lastfm.pages.artist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mikef.lastfm.data.artist.ArtistRepository
import com.mikef.lastfm.data.RepoResult
import com.mikef.lastfm.network.data.artistAlbum.TopAlbumResponse
import com.mikef.lastfm.network.data.artistInfo.ArtistInfoResponse
import com.mikef.lastfm.shared.adapter.AdapterData
import com.mikef.lastfm.shared.navigation.NavigationDelegate
import kotlinx.coroutines.launch

class ArtistInfoViewModel(
    private val artistRepository: ArtistRepository,
    private val dataManager: ArtistInfoDataManager
) : ViewModel() {

    private lateinit var artistName: String

    private val mutableViewState: MutableLiveData<ViewState> = MutableLiveData()
    val viewState: LiveData<ViewState>
        get() = mutableViewState

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
                // TODO
            }
        }
    }

    data class ViewState(
        val artistName: String,
        val artistUrl: String,
        val listData: List<AdapterData<*>>
    )

}
package com.mikef.lastfm.pages.album

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.mikef.lastfm.R
import com.mikef.lastfm.network.data.album.Album
import com.mikef.lastfm.pages.album.adapter.AlbumInfoDataManager
import com.mikef.lastfm.repository.RepoResult
import com.mikef.lastfm.repository.album.AlbumRepository
import com.mikef.lastfm.repository.album.AlbumRepositoryImpl
import com.mikef.lastfm.shared.BaseViewModel
import com.mikef.lastfm.shared.adapter.AdapterData
import kotlinx.coroutines.launch

class AlbumInfoViewModel(
    private val albumRepository: AlbumRepository,
    private val dataManager: AlbumInfoDataManager
) : BaseViewModel<AlbumInfoViewModel.ViewState>() {

    private val mutableSavedState: MutableLiveData<Boolean> = MutableLiveData()
    val savedState: LiveData<Boolean>
        get() = mutableSavedState

    private var album: Album? = null
    private var saved = false

    fun onViewCreated(args: AlbumInfoFragmentArgs) {
        viewModelScope.launch {
            handleResult(albumRepository.getAlbumInfo(args.artistName, args.albumName))
        }
    }

    fun onAlbumSavedClicked() {
        viewModelScope.launch {
            album?.also {
                if (saved) {
                    albumRepository.deleteAlbum(it)
                } else {
                    albumRepository.saveAlbum(it)
                }

                saved = !saved
                mutableSavedState.value = saved
            }
        }
    }

    ///////////////////////////////////////////////////////////////////////////
    // Private methods
    ///////////////////////////////////////////////////////////////////////////

    private fun handleResult(result: RepoResult<AlbumRepositoryImpl.AlbumResponse>) {
        when (result) {
            is RepoResult.Success -> {
                val album = result.value.album
                mutableViewState.value = ViewState(
                    albumName = album.name,
                    artistName = album.artist,
                    albumCoverUrl = album.image.lastOrNull()?.text,
                    listData = dataManager.buildList(album.tracks?.track)
                )

                this.album = album
                this.saved = result.value.saved
                mutableSavedState.value = saved
            }
            is RepoResult.Failure -> {
                mutableError.value = R.string.default_error
            }
        }
    }

    data class ViewState(
        val albumName: String,
        val artistName: String,
        val albumCoverUrl: String?,
        val listData: List<AdapterData<*>>
    )

}
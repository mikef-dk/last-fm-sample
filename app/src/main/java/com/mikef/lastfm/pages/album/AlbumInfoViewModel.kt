package com.mikef.lastfm.pages.album

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mikef.lastfm.data.RepoResult
import com.mikef.lastfm.data.album.AlbumRepository
import com.mikef.lastfm.data.album.AlbumRepositoryImpl
import com.mikef.lastfm.network.data.album.Album
import com.mikef.lastfm.shared.adapter.AdapterData
import kotlinx.coroutines.launch

class AlbumInfoViewModel(
    private val albumRepository: AlbumRepository,
    private val dataManager: AlbumInfoDataManager
) : ViewModel() {

    private val mutableAlbumInfo: MutableLiveData<AlbumInfo> = MutableLiveData()
    val albumInfo: LiveData<AlbumInfo>
        get() = mutableAlbumInfo

    private val mutableSavedState: MutableLiveData<Boolean> = MutableLiveData()
    val savedState: LiveData<Boolean>
        get() = mutableSavedState

    private var album: Album? = null
    private var saved = false

    // TODO: Create BaseViewModel
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
                mutableAlbumInfo.value = AlbumInfo(
                    albumName = album.name,
                    artistName = album.artist,
                    albumCoverUrl = album.image.last().text,
                    listData = dataManager.buildList(album.tracks?.track)
                )

                this.album = album
                this.saved = result.value.saved
                mutableSavedState.value = saved
            }
            is RepoResult.Failure -> {
                // TODO
            }
        }
    }

    data class AlbumInfo(
        val albumName: String,
        val artistName: String,
        val albumCoverUrl: String,
        val listData: List<AdapterData<*>>
    )

}
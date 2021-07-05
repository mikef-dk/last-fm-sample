package com.mikef.lastfm.pages.album

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mikef.lastfm.data.album.AlbumRepository
import com.mikef.lastfm.network.data.album.Album
import kotlinx.coroutines.launch

class AlbumInfoViewModel(
    private val albumRepository: AlbumRepository
) : ViewModel() {

    private var album: Album? = null

    // TODO: Create BaseViewModel
    fun onViewCreated(args: AlbumInfoFragmentArgs) {
        viewModelScope.launch {
            album = albumRepository.getAlbumInfo(args.artistName, args.albumName)
        }
    }

    fun onAlbumSavedClicked(saved: Boolean) {
        viewModelScope.launch {
            album?.also {
                if (saved) {
                    albumRepository.saveAlbum(it)
                } else {
                    albumRepository.deleteAlbum(it)
                }
            }
        }
    }

}
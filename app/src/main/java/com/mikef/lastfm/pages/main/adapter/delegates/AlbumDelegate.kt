package com.mikef.lastfm.pages.main.adapter.delegates

import coil.load
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import com.mikef.lastfm.databinding.RowAlbumBinding
import com.mikef.lastfm.shared.adapter.AdapterData

object AlbumDelegate {

    interface Listener {

        fun onAlbumClicked(artistName: String, albumName: String)

    }

    fun create(listener: Listener) =
        adapterDelegateViewBinding<AlbumData, AdapterData<*>, RowAlbumBinding>(
            { layoutInflater, parent ->
                RowAlbumBinding.inflate(layoutInflater, parent, false)
            }
        ) {

            itemView.setOnClickListener {
                listener.onAlbumClicked(artistName = item.artist, albumName = item.albumName)
            }

            bind {
                binding.albumCover.load(item.imageUrl) {
                    crossfade(true)
                }
                binding.albumTitle.text = item.albumName
            }

        }

    data class AlbumData(
        val imageUrl: String,
        val albumName: String,
        val artist: String
    ) : AdapterData<AlbumData>

}
package com.mikef.lastfm.pages.artist.adapter.delegates

import coil.load
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import com.mikef.lastfm.R
import com.mikef.lastfm.databinding.RowArtistAlbumBinding
import com.mikef.lastfm.shared.adapter.AdapterData

object ArtistAlbumDelegate {

    interface Listener {

        fun onAlbumClicked(albumName: String)

    }

    fun create(listener: Listener) =
        adapterDelegateViewBinding<ArtistAlbumData, AdapterData<*>, RowArtistAlbumBinding>(
            { layoutInflater, parent ->
                RowArtistAlbumBinding.inflate(layoutInflater, parent, false)
            }
        ) {

            itemView.setOnClickListener {
                listener.onAlbumClicked("")
            }

            bind {
                binding.apply {
                    albumCover.load(item.imageUrl) {
                        crossfade(true)
                    }
                    albumName.text = item.albumName
                    albumYear.text =
                        getString(R.string.artist_info_album_playcount_formatter, item.playCount)
                }
            }

        }

    data class ArtistAlbumData(
        val imageUrl: String,
        val albumName: String,
        val playCount: Int,
    ) : AdapterData<ArtistAlbumData>

}
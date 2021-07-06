package com.mikef.lastfm.pages.main.adapter.delegates

import coil.load
import coil.transform.RoundedCornersTransformation
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import com.mikef.lastfm.databinding.RowAlbumBinding
import com.mikef.lastfm.shared.adapter.AdapterData
import com.mikef.lastfm.shared.dp

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
                    transformations(
                        RoundedCornersTransformation(4.dp)
                    )
                }
                binding.albumTitle.text = item.albumName
            }

        }

    data class AlbumData(
        val imageUrl: String,
        val albumName: String,
        val artist: String
    ) : AdapterData<AlbumData> {

        override fun isItemTheSame(data: AlbumData) = albumName == data.albumName

    }

}
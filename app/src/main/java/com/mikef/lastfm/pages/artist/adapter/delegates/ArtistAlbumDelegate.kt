package com.mikef.lastfm.pages.artist.adapter.delegates

import coil.transform.RoundedCornersTransformation
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import com.mikef.lastfm.R
import com.mikef.lastfm.databinding.RowArtistAlbumBinding
import com.mikef.lastfm.shared.adapter.AdapterData
import com.mikef.lastfm.shared.dp
import com.mikef.lastfm.shared.loadImage

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
                listener.onAlbumClicked(item.albumName)
            }

            bind {
                binding.apply {
                    albumCover.loadImage(item.imageUrl) {
                        placeholder(R.drawable.placeholder)
                        crossfade(true)
                        transformations(RoundedCornersTransformation(4.dp))
                    }
                    albumName.text = item.albumName
                    albumPlayCount.text =
                        getString(R.string.artist_info_album_play_count_formatter, item.playCount)
                }
            }

        }

    data class ArtistAlbumData(
        val imageUrl: String,
        val albumName: String,
        val playCount: Int,
    ) : AdapterData<ArtistAlbumData> {

        override fun isItemTheSame(data: ArtistAlbumData) = albumName == albumName

    }

}
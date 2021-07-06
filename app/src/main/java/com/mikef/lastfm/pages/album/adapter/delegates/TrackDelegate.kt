package com.mikef.lastfm.pages.album.adapter.delegates

import android.text.format.DateUtils
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import com.mikef.lastfm.databinding.RowTrackBinding
import com.mikef.lastfm.shared.adapter.AdapterData

object TrackDelegate {

    fun create() =
        adapterDelegateViewBinding<TrackData, AdapterData<*>, RowTrackBinding>(
            { layoutInflater, parent ->
                RowTrackBinding.inflate(layoutInflater, parent, false)
            }
        ) {

            bind {
                binding.apply {
                    rank.text = item.rank.toString()
                    trackName.text = item.trackName
                    trackArtist.text = item.trackArtist
                    trackDuration.text = DateUtils.formatElapsedTime(item.trackDuration.toLong())
                }
            }

        }

    data class TrackData(
        val rank: Int,
        val trackName: String,
        val trackArtist: String,
        val trackDuration: Int
    ) : AdapterData<TrackData>

}
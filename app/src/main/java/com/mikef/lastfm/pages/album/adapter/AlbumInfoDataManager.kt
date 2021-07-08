package com.mikef.lastfm.pages.album.adapter

import com.mikef.lastfm.network.data.album.Track
import com.mikef.lastfm.pages.album.adapter.delegates.TrackDelegate
import com.mikef.lastfm.shared.adapter.AdapterData

class AlbumInfoDataManager {

    fun buildList(trackList: List<Track>?): List<AdapterData<*>> {
        return mutableListOf<AdapterData<*>>().apply {
            trackList?.forEach { track ->
                add(
                    TrackDelegate.TrackData(
                        rank = track.attr.rank,
                        trackName = track.name,
                        trackArtist = track.artist.name,
                        trackDuration = track.duration
                    )
                )
            }
        }
    }

}
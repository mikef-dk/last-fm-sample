package com.mikef.lastfm.pages.main.adapter.delegates

import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import com.mikef.lastfm.databinding.RowAlbumCollectionBinding
import com.mikef.lastfm.pages.main.adapter.AlbumCollectionAdapter
import com.mikef.lastfm.shared.adapter.AdapterData

object AlbumCollectionDelegate {

    fun create(listener: AlbumDelegate.Listener) =
        adapterDelegateViewBinding<AlbumCollectionData, AdapterData<*>, RowAlbumCollectionBinding>(
            { layoutInflater, parent ->
                RowAlbumCollectionBinding.inflate(layoutInflater, parent, false)
            }
        ) {

            val adapter = AlbumCollectionAdapter(listener)
            binding.recyclerView.adapter = adapter

            bind {
                adapter.submitList(item.albums)
            }

        }

    data class AlbumCollectionData(
        val albums: List<AdapterData<*>>
    ) : AdapterData<AlbumCollectionData>

}
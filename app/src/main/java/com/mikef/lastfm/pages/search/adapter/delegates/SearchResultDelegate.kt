package com.mikef.lastfm.pages.search.adapter.delegates

import coil.load
import coil.transform.CircleCropTransformation
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import com.mikef.lastfm.databinding.RowSearchResultBinding
import com.mikef.lastfm.shared.adapter.AdapterData

object SearchResultDelegate {

    interface Listener {

        fun onSearchResultClicked(artistName: String)

    }

    fun create(listener: Listener) =
        adapterDelegateViewBinding<SearchResultData, AdapterData<*>, RowSearchResultBinding>(
            { layoutInflater, parent ->
                RowSearchResultBinding.inflate(layoutInflater, parent, false)
            }
        ) {

            itemView.setOnClickListener {
                listener.onSearchResultClicked(item.artistName)
            }

            bind {
                binding.apply {
                    artistImage.load(item.artistImageUrl) {
                        crossfade(true)
                        transformations(CircleCropTransformation())
                    }

                    artistName.text = item.artistName
                }
            }

        }

    data class SearchResultData(
        val artistImageUrl: String,
        val artistName: String
    ) : AdapterData<SearchResultData> {

        override fun isItemTheSame(data: SearchResultData) = artistName == data.artistName

    }

}
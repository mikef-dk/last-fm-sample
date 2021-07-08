package com.mikef.lastfm.pages.search.adapter.delegates

import coil.transform.CircleCropTransformation
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import com.mikef.lastfm.R
import com.mikef.lastfm.databinding.RowSearchResultBinding
import com.mikef.lastfm.shared.adapter.AdapterData
import com.mikef.lastfm.shared.loadImage

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
                    artistImage.loadImage(item.artistImageUrl) {
                        placeholder(R.drawable.placeholder)
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
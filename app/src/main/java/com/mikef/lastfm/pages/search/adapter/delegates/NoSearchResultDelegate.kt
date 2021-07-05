package com.mikef.lastfm.pages.search.adapter.delegates

import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import com.mikef.lastfm.databinding.RowSearchNoResultBinding
import com.mikef.lastfm.shared.adapter.AdapterData

object NoSearchResultDelegate {

    fun create() =
        adapterDelegateViewBinding<NoSearchResultData, AdapterData<*>, RowSearchNoResultBinding>(
            { layoutInflater, parent ->
                RowSearchNoResultBinding.inflate(layoutInflater, parent, false)
            }
        ) {

            bind {
                binding.text.text = item.text
            }

        }

    data class NoSearchResultData(val text: String) : AdapterData<NoSearchResultData>

}
package com.mikef.lastfm.pages.main.adapter.delegates

import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import com.mikef.lastfm.databinding.RowTitleBinding
import com.mikef.lastfm.shared.adapter.AdapterData

object TitleDelegate {

    fun create() = adapterDelegateViewBinding<MainTitleData, AdapterData<*>, RowTitleBinding>(
        { layoutInflater, parent ->
            RowTitleBinding.inflate(layoutInflater, parent, false)
        }
    ) {

        bind {
            binding.title.text = item.title
        }

    }

    data class MainTitleData(val title: String) : AdapterData<MainTitleData>{

        override fun isItemTheSame(data: MainTitleData) = title == data.title

    }

}
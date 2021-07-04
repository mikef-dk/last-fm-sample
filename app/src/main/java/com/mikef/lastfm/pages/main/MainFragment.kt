package com.mikef.lastfm.pages.main

import android.os.Bundle
import android.view.View
import com.mikef.lastfm.databinding.FragmentMainBinding
import com.mikef.lastfm.pages.main.adapter.MainAdapter
import com.mikef.lastfm.pages.main.adapter.delegates.AlbumDelegate
import com.mikef.lastfm.shared.BindableFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : BindableFragment<FragmentMainBinding>(
    FragmentMainBinding::inflate
), AlbumDelegate.Listener {

    private val adapter by lazy {
        MainAdapter(this)
    }

    val viewModel: MainViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
        viewModel.onViewCreated()
    }

    ///////////////////////////////////////////////////////////////////////////
    // Private methods
    ///////////////////////////////////////////////////////////////////////////

    private fun initView() {
        binding.recyclerView.adapter = adapter
        observeData()
    }

    private fun observeData() {

    }

    ///////////////////////////////////////////////////////////////////////////
    // AlbumDelegate.Listener
    ///////////////////////////////////////////////////////////////////////////

    override fun onAlbumClicked(artist: String, album: String) {
        viewModel.onAlbumClicked(artist, album)
    }

}
package com.mikef.lastfm.pages.main

import android.os.Bundle
import android.view.View
import com.mikef.lastfm.databinding.FragmentMainBinding
import com.mikef.lastfm.pages.main.adapter.MainAdapter
import com.mikef.lastfm.pages.main.adapter.delegates.AlbumDelegate
import com.mikef.lastfm.shared.BaseFragment
import com.mikef.lastfm.shared.disableChangeAnimation
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : BaseFragment<FragmentMainBinding, MainViewModel>(
    FragmentMainBinding::inflate
), AlbumDelegate.Listener {

    private val adapter by lazy {
        MainAdapter(this)
    }

    override val viewModel: MainViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
        viewModel.onViewCreated()
    }

    ///////////////////////////////////////////////////////////////////////////
    // Private methods
    ///////////////////////////////////////////////////////////////////////////

    private fun initView() {
        binding.apply {
            recyclerView.adapter = adapter
            recyclerView.disableChangeAnimation()

            extendedFab.setOnClickListener {
                viewModel.onSearchClicked(navigationDelegate)
            }
        }

        observeData()
    }

    private fun observeData() {
        viewModel.viewState.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

    ///////////////////////////////////////////////////////////////////////////
    // AlbumDelegate.Listener
    ///////////////////////////////////////////////////////////////////////////

    override fun onAlbumClicked(artistName: String, albumName: String) {
        viewModel.onAlbumClicked(navigationDelegate, artistName, albumName)
    }

}
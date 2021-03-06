package com.mikef.lastfm.pages.artist

import android.os.Bundle
import android.view.View
import com.mikef.lastfm.R
import com.mikef.lastfm.databinding.FragmentArtistInfoBinding
import com.mikef.lastfm.pages.artist.adapter.ArtistInfoAdapter
import com.mikef.lastfm.pages.artist.adapter.delegates.ArtistAlbumDelegate
import com.mikef.lastfm.shared.BaseFragment
import com.mikef.lastfm.shared.loadImage
import org.koin.androidx.viewmodel.ext.android.viewModel

class ArtistInfoFragment : BaseFragment<FragmentArtistInfoBinding, ArtistInfoViewModel>(
    FragmentArtistInfoBinding::inflate
), ArtistAlbumDelegate.Listener {

    override val viewModel: ArtistInfoViewModel by viewModel()

    private val adapter by lazy {
        ArtistInfoAdapter(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        viewModel.onViewCreated(ArtistInfoFragmentArgs.fromBundle(requireArguments()))
    }

    ///////////////////////////////////////////////////////////////////////////
    // Private methods
    ///////////////////////////////////////////////////////////////////////////

    private fun initView() {
        binding.recyclerView.adapter = adapter
        binding.back.setOnClickListener {
            viewModel.onBackClicked(navigationDelegate)
        }

        viewModel.viewState.observe(viewLifecycleOwner) {
            adapter.submitList(it.listData)

            binding.apply {
                artistName.text = it.artistName
                title.text = it.artistName
                artistImage.loadImage(it.artistUrl) {
                    placeholder(R.drawable.placeholder)
                    crossfade(true)
                }
            }
        }
    }

    ///////////////////////////////////////////////////////////////////////////
    // AlbumDelegate.Listener
    ///////////////////////////////////////////////////////////////////////////

    override fun onAlbumClicked(albumName: String) {
        viewModel.onAlbumClicked(navigationDelegate, albumName)
    }

}
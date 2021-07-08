package com.mikef.lastfm.pages.album

import android.os.Bundle
import android.view.View
import coil.transform.RoundedCornersTransformation
import com.mikef.lastfm.R
import com.mikef.lastfm.databinding.FragmentAlbumInfoBinding
import com.mikef.lastfm.pages.album.adapter.AlbumInfoAdapter
import com.mikef.lastfm.shared.BaseFragment
import com.mikef.lastfm.shared.dp
import com.mikef.lastfm.shared.loadImage
import org.koin.androidx.viewmodel.ext.android.viewModel

class AlbumInfoFragment : BaseFragment<FragmentAlbumInfoBinding, AlbumInfoViewModel>(
    FragmentAlbumInfoBinding::inflate
) {

    override val viewModel: AlbumInfoViewModel by viewModel()

    private val adapter by lazy {
        AlbumInfoAdapter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        viewModel.onViewCreated(AlbumInfoFragmentArgs.fromBundle(requireArguments()))
    }

    ///////////////////////////////////////////////////////////////////////////
    // Private methods
    ///////////////////////////////////////////////////////////////////////////

    private fun initView() {
        binding.apply {
            cta.setOnClickListener {
                viewModel.onAlbumSavedClicked()
            }
            recyclerView.adapter = adapter
            toolbar.setNavigationOnClickListener {
                viewModel.onBackClicked(navigationDelegate)
            }
        }

        observeData()
    }

    private fun observeData() {
        viewModel.viewState.observe(viewLifecycleOwner) {
            binding.apply {
                albumName.text = it.albumName
                artistName.text = getString(R.string.album_info_artist_formatter, it.artistName)
                albumImage.loadImage(it.albumCoverUrl) {
                    placeholder(R.drawable.placeholder)
                    crossfade(true)
                    transformations(
                        RoundedCornersTransformation(4.dp)
                    )
                }

                adapter.submitList(it.listData)
            }
        }

        viewModel.savedState.observe(viewLifecycleOwner) {
            val text = when (it) {
                true -> R.string.album_info_delete
                else -> R.string.album_info_save
            }
            binding.cta.apply {
                isEnabled = true
                this.text = getString(text)
            }
        }
    }

}
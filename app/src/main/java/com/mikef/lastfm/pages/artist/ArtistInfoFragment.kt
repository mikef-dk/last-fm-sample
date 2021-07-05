package com.mikef.lastfm.pages.artist

import com.mikef.lastfm.databinding.FragmentArtistInfoBinding
import com.mikef.lastfm.shared.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class ArtistInfoFragment : BaseFragment<FragmentArtistInfoBinding, ArtistInfoViewModel>(
    FragmentArtistInfoBinding::inflate
) {

    override val viewModel: ArtistInfoViewModel by viewModel()

}
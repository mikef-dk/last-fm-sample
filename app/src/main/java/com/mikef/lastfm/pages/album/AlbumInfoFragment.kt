package com.mikef.lastfm.pages.album

import com.mikef.lastfm.databinding.FragmentAlbumInfoBinding
import com.mikef.lastfm.shared.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class AlbumInfoFragment : BaseFragment<FragmentAlbumInfoBinding, AlbumInfoViewModel>(
    FragmentAlbumInfoBinding::inflate
) {

    override val viewModel: AlbumInfoViewModel by viewModel()

}
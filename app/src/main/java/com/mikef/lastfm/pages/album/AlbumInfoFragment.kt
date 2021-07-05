package com.mikef.lastfm.pages.album

import android.os.Bundle
import android.view.View
import com.mikef.lastfm.databinding.FragmentAlbumInfoBinding
import com.mikef.lastfm.pages.main.adapter.delegates.AlbumDelegate
import com.mikef.lastfm.shared.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class AlbumInfoFragment : BaseFragment<FragmentAlbumInfoBinding, AlbumInfoViewModel>(
    FragmentAlbumInfoBinding::inflate
){

    override val viewModel: AlbumInfoViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.onViewCreated(AlbumInfoFragmentArgs.fromBundle(requireArguments()))
    }

}
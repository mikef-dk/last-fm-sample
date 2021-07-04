package com.mikef.lastfm.pages.main

import android.os.Bundle
import android.view.View
import com.mikef.lastfm.databinding.FragmentMainBinding
import com.mikef.lastfm.shared.BindableFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : BindableFragment<FragmentMainBinding>(
    FragmentMainBinding::inflate
) {

    val viewModel: MainViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.text.setOnClickListener {
            viewModel.onViewCreated()
        }
    }

}
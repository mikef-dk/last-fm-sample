package com.mikef.lastfm.pages.search

import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.mikef.lastfm.databinding.FragmentSearchBinding
import com.mikef.lastfm.pages.search.adapter.SearchAdapter
import com.mikef.lastfm.pages.search.adapter.delegates.SearchResultDelegate
import com.mikef.lastfm.shared.BaseFragment
import com.mikef.lastfm.shared.onQueryChanged
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchFragment : BaseFragment<FragmentSearchBinding, SearchViewModel>(
    FragmentSearchBinding::inflate
), SearchResultDelegate.Listener {

    private val adapter by lazy {
        SearchAdapter(this)
    }

    override val viewModel: SearchViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
    }

    ///////////////////////////////////////////////////////////////////////////
    // Private methods
    ///////////////////////////////////////////////////////////////////////////

    private fun initView() {
        binding.recyclerView.adapter = adapter
        observeData()

        binding.searchEditText.onQueryChanged()
            .debounce(500)
            .onEach {
                viewModel.onSearchQueryChanged(it?.toString() ?: "")
            }
            .launchIn(viewLifecycleOwner.lifecycleScope)
    }

    private fun observeData() {
        viewModel.listData.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

    ///////////////////////////////////////////////////////////////////////////
    // SearchResultDelegate.Listener
    ///////////////////////////////////////////////////////////////////////////

    override fun onSearchResultClicked(artistName: String) {
        viewModel.onSearchResultClicked(navigationDelegate, artistName)
    }
}
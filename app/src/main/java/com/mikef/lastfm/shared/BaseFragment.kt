package com.mikef.lastfm.shared

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.StringRes
import androidx.viewbinding.ViewBinding
import com.google.android.material.snackbar.Snackbar
import com.mikef.lastfm.shared.navigation.NavigationDelegate
import org.koin.androidx.scope.ScopeActivity

abstract class BaseFragment<VB : ViewBinding, VM : BaseViewModel<*>>(
    viewBindingFactory: (LayoutInflater, ViewGroup?, Boolean) -> VB
) : BindableFragment<VB>(viewBindingFactory) {

    protected val navigationDelegate: NavigationDelegate by lazy {
        (requireActivity() as ScopeActivity).scope.get()
    }

    protected abstract val viewModel: VM

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.error.observe(viewLifecycleOwner) {
            showError(it)
        }
    }

    protected fun showError(@StringRes stringRes: Int) {
        Snackbar.make(requireView(), stringRes, Snackbar.LENGTH_LONG).show()
    }

}
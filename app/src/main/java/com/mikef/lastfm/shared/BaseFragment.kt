package com.mikef.lastfm.shared

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding
import com.mikef.lastfm.shared.navigation.NavigationDelegate
import org.koin.androidx.scope.ScopeActivity

abstract class BaseFragment<VB : ViewBinding, T : ViewModel>(
    viewBindingFactory: (LayoutInflater, ViewGroup?, Boolean) -> VB
) : BindableFragment<VB>(viewBindingFactory) {

    protected val navigationDelegate: NavigationDelegate by lazy {
        (requireActivity() as ScopeActivity).scope.get()
    }

    protected abstract val viewModel: T

}
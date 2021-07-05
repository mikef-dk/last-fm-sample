package com.mikef.lastfm.shared

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.viewbinding.ViewBinding
import org.koin.androidx.scope.ScopeFragment

abstract class BindableFragment<VB : ViewBinding>(
    private val viewBindingFactory: (LayoutInflater, ViewGroup?, Boolean) -> VB
) : ScopeFragment() {

    var nullableBinding: VB? = null

    var binding: VB
        private set(value) {
            nullableBinding = value
        }
        get() = checkNotNull(nullableBinding)

    @CallSuper
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return viewBindingFactory(inflater, container, false).also {
            nullableBinding = it
        }.root
    }

    @CallSuper
    override fun onDestroyView() {
        super.onDestroyView()
        nullableBinding = null
    }

    fun requireBinding(): VB = checkNotNull(nullableBinding)

    inline fun withBinding(block: VB.() -> Unit) {
        nullableBinding?.block()
    }
}
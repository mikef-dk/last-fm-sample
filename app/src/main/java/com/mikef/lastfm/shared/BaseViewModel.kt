package com.mikef.lastfm.shared

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mikef.lastfm.shared.navigation.NavigationDelegate

abstract class BaseViewModel<T> : ViewModel() {

    protected val mutableViewState: MutableLiveData<T> = MutableLiveData()
    val viewState: LiveData<T>
        get() = mutableViewState

    protected val mutableError: MutableLiveData<Int> = MutableLiveData()
    val error: LiveData<Int>
        get() = mutableError

    open fun onBackClicked(navigationDelegate: NavigationDelegate) {
        navigationDelegate.goBack()
    }

}
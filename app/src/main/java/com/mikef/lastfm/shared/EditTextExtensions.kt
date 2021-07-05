package com.mikef.lastfm.shared

import android.widget.EditText
import androidx.core.widget.doOnTextChanged
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow

@ExperimentalCoroutinesApi
fun EditText.onQueryChanged() = callbackFlow {
    val watcher = doOnTextChanged { text, _, _, _ ->
        trySend(text)
    }
    awaitClose { removeTextChangedListener(watcher) }
}
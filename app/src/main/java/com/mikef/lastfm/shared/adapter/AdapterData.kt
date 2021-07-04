package com.mikef.lastfm.shared.adapter

interface AdapterData<T> {

    fun isItemTheSame(data: T): Boolean {
        return false
    }
}
package com.mikef.lastfm.shared.resprovider

import android.content.Context
import androidx.annotation.StringRes

class ResProviderImpl(private val context: Context) : ResProvider {

    override fun getString(@StringRes stringRes: Int): String {
        return context.getString(stringRes)
    }

    override fun getString(@StringRes stringRes: Int, vararg formatArgs: Any): String {
        return context.getString(stringRes, *formatArgs)
    }

}
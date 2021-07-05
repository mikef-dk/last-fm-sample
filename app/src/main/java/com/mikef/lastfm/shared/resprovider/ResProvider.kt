package com.mikef.lastfm.shared.resprovider

import androidx.annotation.StringRes

interface ResProvider {

    fun getString(@StringRes stringRes: Int): String

    fun getString(@StringRes stringRes: Int, vararg formatArgs: Any): String

}
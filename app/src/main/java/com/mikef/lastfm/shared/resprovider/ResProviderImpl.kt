package com.mikef.lastfm.shared.resprovider

import android.content.Context
import androidx.annotation.StringRes

class ResProviderImpl(private val context: Context) : ResProvider {

    override fun getString(@StringRes stringRes: Int): String {
        return context.getString(stringRes)
    }

    override fun getString(@StringRes stringRes: Int, vararg formatArgs: Any): String {
        // Usually this would work but latest AGP breaks because of R8 NPE
        return """Sorry - formatted getString is broken with latest AGP/R8 ¯\_(ツ)_/¯"""
//        return context.getString(stringRes, *formatArgs)
    }

}
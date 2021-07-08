package com.mikef.lastfm.shared

import android.widget.ImageView
import coil.ImageLoader
import coil.imageLoader
import coil.loadAny
import coil.request.ImageRequest

inline fun ImageView.loadImage(
    uri: String?,
    imageLoader: ImageLoader = context.imageLoader,
    builder: ImageRequest.Builder.() -> Unit = {}
) {
    if (!uri.isNullOrEmpty()) {
        loadAny(uri, imageLoader, builder)
    }
}
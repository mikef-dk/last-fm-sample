package com.mikef.lastfm.data

sealed class RepoResult<T> {

    data class Success<T>(val value: T) : RepoResult<T>()

    data class Failure<T>(val throwable: Throwable) : RepoResult<T>()

}
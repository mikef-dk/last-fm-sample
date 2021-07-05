package com.mikef.lastfm.network

sealed class ApiResult<T> {

    data class Success<T>(val value: T) : ApiResult<T>()

    data class Failure<T>(val throwable: Throwable) : ApiResult<T>()

}
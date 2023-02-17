package com.yellowishdev.api.coingecko.dto


sealed class Response<T>(
    data: T? = null,
    exception: Exception? = null
) {
    data class Success<T>(val data: T) : Response<T>(data, null)
    data class Error<T>(val exception: Exception) : Response<T>(null, exception)
}
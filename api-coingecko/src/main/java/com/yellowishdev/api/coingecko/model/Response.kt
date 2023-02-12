package com.yellowishdev.api.coingecko.model

import com.google.gson.annotations.SerializedName

sealed class Response {

    data class Ping(
        @SerializedName("gecko_says")
        val geckoSays: String
    ): Response()

}
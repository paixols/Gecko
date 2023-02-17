package com.yellowishdev.api.coingecko.dto

import com.google.gson.annotations.SerializedName

data class Ping(
    @SerializedName("gecko_says")
    val geckoSays: String
)
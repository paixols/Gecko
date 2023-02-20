package com.yellowishdev.api.coingecko.dto

import com.google.gson.annotations.SerializedName

data class CurrentPrice(
    @SerializedName("usd")
    val usd: Double,
    @SerializedName("btc")
    val btc: Double
)
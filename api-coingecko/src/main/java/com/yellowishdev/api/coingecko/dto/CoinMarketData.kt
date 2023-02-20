package com.yellowishdev.api.coingecko.dto

import com.google.gson.annotations.SerializedName

data class CoinMarketData(
    @SerializedName("current_price")
    val currentPrice: CurrentPrice
)
package com.yellowishdev.api.coingecko.dto

import com.google.gson.annotations.SerializedName

data class CoinInformation(
    @SerializedName("market_data")
    val marketData: CoinMarketData

)
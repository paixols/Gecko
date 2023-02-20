package com.yellowishdev.gecko.data.model

sealed class CoingeckoRequest {

    data class MarketData(
        val coinId: String
    ) : CoingeckoRequest()

}
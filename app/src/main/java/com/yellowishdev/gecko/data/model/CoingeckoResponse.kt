package com.yellowishdev.gecko.data.model

sealed class CoingeckoResponse {

    data class Ping(
        val message: String
    ) : CoingeckoResponse()

    data class Coins(
        val coinList: List<Coin>
    ) : CoingeckoResponse()

    data class Error(
        val exception: Exception
    ) : CoingeckoResponse()

}
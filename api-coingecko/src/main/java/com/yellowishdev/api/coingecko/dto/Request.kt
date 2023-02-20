package com.yellowishdev.api.coingecko.dto

sealed class Request {

    object Empty : Request()

    data class MarketData(
        val id: String
    ) : Request()

}
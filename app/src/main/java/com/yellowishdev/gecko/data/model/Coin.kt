package com.yellowishdev.gecko.data.model

data class Coin(
    val id: String,
    val symbol: String,
    val name: String,
    var usdPrice: Double? = null,
    var btcPrice: Double? = null
)
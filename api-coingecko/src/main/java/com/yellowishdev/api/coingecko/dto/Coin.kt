package com.yellowishdev.api.coingecko.dto

import com.google.gson.annotations.SerializedName

data class Coin(
    @SerializedName("id")
    val id: String,
    @SerializedName("symbol")
    val symbol: String,
    @SerializedName("name")
    val name: String
)
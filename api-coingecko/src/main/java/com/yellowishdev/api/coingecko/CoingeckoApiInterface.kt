package com.yellowishdev.api.coingecko

import com.yellowishdev.api.coingecko.dto.Coin
import com.yellowishdev.api.coingecko.dto.Ping
import com.yellowishdev.api.coingecko.dto.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface CoingeckoApiInterface {
    @GET
    suspend fun ping(@Url url: String): Ping

    @GET
    suspend fun coinList(@Url url: String): List<Coin>
}
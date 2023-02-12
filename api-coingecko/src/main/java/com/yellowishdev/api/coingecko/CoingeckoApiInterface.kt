package com.yellowishdev.api.coingecko

import com.yellowishdev.api.coingecko.model.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface CoingeckoApiInterface {
    @GET
    suspend fun ping(@Url url: String): Response.Ping
}
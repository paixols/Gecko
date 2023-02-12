package com.yellowishdev.api.coingecko

import com.yellowishdev.api.coingecko.model.Response
import retrofit2.Retrofit
import javax.inject.Inject

interface CoingeckoServiceInterface {
    suspend fun pingApi(): Response.Ping
}

class CoingeckoService @Inject constructor(
    retrofit: Retrofit
) : CoingeckoServiceInterface {

    private var coingeckoApiInterface =
        retrofit.create(CoingeckoApiInterface::class.java)

    private val baseUrl = "https://api.coingecko.com/api/v3/"

    override suspend fun pingApi(): Response.Ping =
        coingeckoApiInterface.ping(baseUrl+"ping")
}
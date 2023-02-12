package com.yellowishdev.gecko.data.source

import com.yellowishdev.api.coingecko.CoingeckoService
import com.yellowishdev.api.coingecko.model.Response
import javax.inject.Inject

interface CoinsDataSourceInterface {
    suspend fun ping(): Response.Ping
}

class CoinsDataSource @Inject constructor(
    private val coingeckoApi: CoingeckoService
): CoinsDataSourceInterface {

    override suspend fun ping(): Response.Ping =
        coingeckoApi.pingApi()

}
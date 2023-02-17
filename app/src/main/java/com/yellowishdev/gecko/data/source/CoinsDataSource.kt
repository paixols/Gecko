package com.yellowishdev.gecko.data.source

import com.yellowishdev.api.coingecko.CoingeckoService
import com.yellowishdev.api.coingecko.dto.Coin
import com.yellowishdev.api.coingecko.dto.Ping
import com.yellowishdev.api.coingecko.dto.Response
import javax.inject.Inject

interface CoinsDataSourceInterface {
    suspend fun pingApi(): Response<Ping>
    suspend fun coinList(): Response<List<Coin>>
}

class CoinsDataSource @Inject constructor(
    private val coingeckoApi: CoingeckoService
) : CoinsDataSourceInterface {

    override suspend fun pingApi(): Response<Ping> =
        coingeckoApi.pingApi()

    override suspend fun coinList(): Response<List<Coin>> =
        coingeckoApi.coinList()

    // Would provide from multiple data sources if required

}
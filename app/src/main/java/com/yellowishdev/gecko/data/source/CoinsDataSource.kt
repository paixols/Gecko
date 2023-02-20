package com.yellowishdev.gecko.data.source

import com.yellowishdev.api.coingecko.CoingeckoService
import com.yellowishdev.api.coingecko.dto.*
import com.yellowishdev.gecko.data.model.CoingeckoRequest
import javax.inject.Inject

interface CoinsDataSourceInterface {
    suspend fun pingApi(): Response<Ping>
    suspend fun coinList(): Response<List<Coin>>
    suspend fun coinInformation(request: CoingeckoRequest.MarketData): Response<CoinInformation>
}

class CoinsDataSource @Inject constructor(
    private val coingeckoApi: CoingeckoService
) : CoinsDataSourceInterface {

    override suspend fun pingApi(): Response<Ping> =
        coingeckoApi.pingApi()

    override suspend fun coinList(): Response<List<Coin>> =
        coingeckoApi.coinList()

    override suspend fun coinInformation(request: CoingeckoRequest.MarketData): Response<CoinInformation> =
        coingeckoApi.coinMarketData(
            request = Request.MarketData(request.coinId)
        )

    // Would provide from multiple data sources if required

}
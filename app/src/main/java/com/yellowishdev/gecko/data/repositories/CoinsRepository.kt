package com.yellowishdev.gecko.data.repositories

import com.yellowishdev.api.coingecko.dto.Response
import com.yellowishdev.gecko.data.mappers.CoingeckoMapperInterface
import com.yellowishdev.gecko.data.model.CoingeckoRequest
import com.yellowishdev.gecko.data.model.CoingeckoResponse
import com.yellowishdev.gecko.data.source.CoinsDataSourceInterface
import javax.inject.Inject

interface CoinsRepositoryInterface {
    suspend fun ping(): CoingeckoResponse
    suspend fun coinList(): CoingeckoResponse
    suspend fun coinInformation(request: CoingeckoRequest.MarketData): CoingeckoResponse
}

class CoinsRepository @Inject constructor(
    private val coinsDataSource: CoinsDataSourceInterface,
    private val coingeckoMapperInterface: CoingeckoMapperInterface
) : CoinsRepositoryInterface {

    override suspend fun ping(): CoingeckoResponse =
        coinsDataSource.pingApi().let { response ->
            when (response) {
                is Response.Success -> CoingeckoResponse.Ping(
                    message = response.data.geckoSays
                )
                is Response.Error -> CoingeckoResponse.Error(
                    exception = response.exception
                )
            }
        }


    override suspend fun coinList(): CoingeckoResponse =
        coinsDataSource.coinList().let { response ->
            when (response) {
                is Response.Success -> CoingeckoResponse.Coins(
                    coinList = response.data.map { coingeckoMapperInterface.toDomainModel(it) }
                )
                is Response.Error -> CoingeckoResponse.Error(
                    exception = response.exception
                )
            }
        }

    override suspend fun coinInformation(request: CoingeckoRequest.MarketData): CoingeckoResponse =
        coinsDataSource.coinInformation(request).let { response ->
            when (response) {
                is Response.Success -> CoingeckoResponse.CoinMarketData(
                    marketPricing = coingeckoMapperInterface.mapCoinMarketPricing(
                        response.data.marketData
                    )
                )
                is Response.Error -> CoingeckoResponse.Error(
                    exception = response.exception
                )
            }
        }


    // Would provide local data if there was no network connection
}
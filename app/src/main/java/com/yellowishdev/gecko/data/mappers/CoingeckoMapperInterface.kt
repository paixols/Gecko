package com.yellowishdev.gecko.data.mappers

import com.yellowishdev.api.coingecko.dto.Coin
import com.yellowishdev.api.coingecko.dto.CoinMarketData
import com.yellowishdev.gecko.data.model.CoinMarketPricing
import javax.inject.Inject

interface CoingeckoMapperInterface {
    fun toDomainModel(coin: Coin): com.yellowishdev.gecko.data.model.Coin
    fun mapCoinMarketPricing(coinMarketData: CoinMarketData): CoinMarketPricing
}

class CoingeckoMapper @Inject constructor() : CoingeckoMapperInterface {

    override fun toDomainModel(coin: Coin): com.yellowishdev.gecko.data.model.Coin =
        com.yellowishdev.gecko.data.model.Coin(
            id = coin.id,
            symbol = coin.symbol,
            name = coin.name
        )

    override fun mapCoinMarketPricing(coinMarketData: CoinMarketData): CoinMarketPricing =
        CoinMarketPricing(
            usd = coinMarketData.currentPrice.usd,
            btc = coinMarketData.currentPrice.btc
        )

}
package com.yellowishdev.gecko.data.mappers

import com.yellowishdev.api.coingecko.dto.Coin
import javax.inject.Inject

interface CoingeckoMapperInterface {
    fun toDomainModel(coin: Coin): com.yellowishdev.gecko.data.model.Coin
}

class CoingeckoMapper @Inject constructor() : CoingeckoMapperInterface {

    override fun toDomainModel(coin: Coin): com.yellowishdev.gecko.data.model.Coin =
        com.yellowishdev.gecko.data.model.Coin(
            id = coin.id,
            symbol = coin.symbol,
            name = coin.name
        )

}
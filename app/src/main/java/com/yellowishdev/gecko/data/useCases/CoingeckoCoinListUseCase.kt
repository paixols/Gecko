package com.yellowishdev.gecko.data.useCases

import com.yellowishdev.api.coingecko.dto.Request
import com.yellowishdev.gecko.data.model.Coin
import com.yellowishdev.gecko.data.model.CoingeckoResponse
import com.yellowishdev.gecko.data.repositories.CoinsRepositoryInterface
import javax.inject.Inject

class CoingeckoCoinListUseCase @Inject constructor(
    private val coinsRepository: CoinsRepositoryInterface
) : BaseUseCase<CoingeckoResponse, Request.Empty> {

    override suspend fun invoke(param: Request.Empty): CoingeckoResponse =
        filterTopCoins(coinsRepository.coinList())

    private fun filterTopCoins(coingeckoResponse: CoingeckoResponse): CoingeckoResponse {
        return if (coingeckoResponse is CoingeckoResponse.Coins) {
            val topCoins = mutableListOf<Coin>()
            coingeckoResponse.coinList.filterTo(topCoins) {
                it.symbol == "btc"              ||  // Bitcoin
                        it.symbol == "bch"      ||  // Bitcoin cash
                        it.symbol == "eth"      ||  // Ethereum
                        it.symbol == "ltc"      ||  // Litecoin
                        it.symbol == "celo"     ||  // Celo
                        it.symbol == "usdt"     ||  // Tether
                        it.symbol == "ada"      ||  // Cardano
                        it.symbol == "matic"    ||  // Polygon
                        it.symbol == "doge"     ||  // Doge
                        it.symbol == "sol"          // Solana
            }
            CoingeckoResponse.Coins(coinList = topCoins)
        } else {
            coingeckoResponse
        }
    }

}
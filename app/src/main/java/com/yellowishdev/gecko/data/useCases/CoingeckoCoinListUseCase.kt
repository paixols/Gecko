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
                (it.symbol == "btc" && it.id == "btc")                          ||  // Bitcoin
                        (it.symbol == "bch" && it.id == "bitcoin-cash")         ||  // Bitcoin cash
                        (it.symbol == "eth" && it.id == "ethereum")             ||  // Ethereum
                        (it.symbol == "ltc" && it.id == "litecoin")             ||  // Litecoin
                        (it.symbol == "celo" && it.id == "celo")                ||  // Celo
                        (it.symbol == "usdt" && it.id == "tether")              ||  // Tether
                        (it.symbol == "ada" && it.id == "cardano")              ||  // Cardano
                        (it.symbol == "matic" && it.name == "Polygon")          ||  // Polygon
                        (it.symbol == "doge" && it.id == "dogecoin")            ||  // Doge
                        (it.symbol == "sol" && it.id == "solana")                   // Solana
            }
            CoingeckoResponse.Coins(coinList = topCoins)
        } else {
            coingeckoResponse
        }
    }

}
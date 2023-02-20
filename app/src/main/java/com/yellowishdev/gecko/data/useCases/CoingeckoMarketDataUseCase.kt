package com.yellowishdev.gecko.data.useCases

import com.yellowishdev.gecko.data.model.CoingeckoRequest
import com.yellowishdev.gecko.data.model.CoingeckoResponse
import com.yellowishdev.gecko.data.repositories.CoinsRepositoryInterface
import javax.inject.Inject

class CoingeckoMarketDataUseCase @Inject constructor(
    private val coinsRepository: CoinsRepositoryInterface
) : BaseUseCase<CoingeckoResponse, String> {

    override suspend fun invoke(coinId: String): CoingeckoResponse =
        coinsRepository.coinInformation(
            CoingeckoRequest.MarketData(coinId = coinId)
        )

    // Would filter & manipulate data based on use case if required

}
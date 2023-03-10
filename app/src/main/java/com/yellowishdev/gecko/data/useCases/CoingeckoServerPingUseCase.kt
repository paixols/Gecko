package com.yellowishdev.gecko.data.useCases

import com.yellowishdev.api.coingecko.dto.Request
import com.yellowishdev.gecko.data.model.CoingeckoResponse
import com.yellowishdev.gecko.data.repositories.CoinsRepositoryInterface
import javax.inject.Inject

class CoingeckoServerPingUseCase @Inject constructor(
    private val coinsRepository: CoinsRepositoryInterface
) : BaseUseCase<CoingeckoResponse, Request.Empty> {

    override suspend fun invoke(param: Request.Empty): CoingeckoResponse =
        coinsRepository.ping()

    // Would filter & manipulate data based on use case if required
}
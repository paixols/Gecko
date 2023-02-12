package com.yellowishdev.gecko.data.useCases

import com.yellowishdev.api.coingecko.model.Request
import com.yellowishdev.api.coingecko.model.Response
import com.yellowishdev.api.coingecko.repositories.CoinsRepositoryInterface
import javax.inject.Inject

class CoingeckoServerPingUseCase @Inject constructor(
    private val coinsRepository: CoinsRepositoryInterface
) : BaseUseCase<Response.Ping, Request.Empty> {
    override suspend fun invoke(param: Request.Empty): Response.Ping =
        coinsRepository.ping()
}
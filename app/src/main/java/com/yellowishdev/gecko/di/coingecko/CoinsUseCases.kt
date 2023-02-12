package com.yellowishdev.gecko.di.coingecko

import com.yellowishdev.api.coingecko.repositories.CoinsRepositoryInterface
import com.yellowishdev.gecko.data.useCases.CoingeckoServerPingUseCase
import dagger.Module
import dagger.Provides

@Module
object CoinsUseCases {

    @Provides
    fun provideCoingeckoServerPingUseCase(
        coinsRepositoryInterface: CoinsRepositoryInterface
    ): CoingeckoServerPingUseCase =
        CoingeckoServerPingUseCase(coinsRepositoryInterface)

}
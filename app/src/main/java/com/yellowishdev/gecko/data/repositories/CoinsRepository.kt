package com.yellowishdev.gecko.data.repositories

import com.yellowishdev.api.coingecko.model.Response
import com.yellowishdev.api.coingecko.repositories.CoinsRepositoryInterface
import com.yellowishdev.gecko.data.source.CoinsDataSourceInterface
import javax.inject.Inject

class CoinsRepository @Inject constructor(
    private val coinsDataSource: CoinsDataSourceInterface
): CoinsRepositoryInterface {

    override suspend fun ping(): Response.Ping =
        coinsDataSource.ping()

    /*
    * Would provide local data source here if there was no internet connection
    * */
}
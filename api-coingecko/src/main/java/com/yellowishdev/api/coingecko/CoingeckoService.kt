package com.yellowishdev.api.coingecko

import com.yellowishdev.api.coingecko.dto.Coin
import com.yellowishdev.api.coingecko.dto.Ping
import com.yellowishdev.api.coingecko.dto.Response
import retrofit2.HttpException
import retrofit2.Retrofit
import java.io.IOException
import javax.inject.Inject

interface CoingeckoServiceInterface {
    suspend fun pingApi(): Response<Ping>
    suspend fun coinList(): Response<List<Coin>>
}

class CoingeckoService @Inject constructor(
    retrofit: Retrofit
) : CoingeckoServiceInterface {

    private var coingeckoApiInterface =
        retrofit.create(CoingeckoApiInterface::class.java)

    private val baseUrl = "https://api.coingecko.com/api/v3/"

    override suspend fun pingApi(): Response<Ping> {
        return try {
            Response.Success(
                coingeckoApiInterface.ping(baseUrl + "ping")
            )
        } catch (e: HttpException) {
            Response.Error(e)
        } catch (e: IOException) {
            Response.Error(e)
        }
    }

    override suspend fun coinList(): Response<List<Coin>> {
        return try {
            Response.Success(
                coingeckoApiInterface.coinList(baseUrl + "coins/list?include_platform=false")
            )
        } catch (e: HttpException) {
            Response.Error(e)
        } catch (e: IOException) {
            Response.Error(e)
        }
    }

}
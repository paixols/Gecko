package com.yellowishdev.api.coingecko.repositories

import com.yellowishdev.api.coingecko.model.Response

interface CoinsRepositoryInterface {
    suspend fun ping(): Response.Ping
}
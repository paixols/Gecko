package com.yellowishdev.gecko.utils

import com.yellowishdev.gecko.data.model.Coin

object DataSet {
    val coinListSample = listOf<Coin>(
        Coin(
            id = "bitcoin",
            symbol = "btc",
            name = "Bitcoin"
        ),
        Coin(
            id = "bitcoin-cash",
            symbol = "bch",
            name = "Bitcoin Cash"
        ),
        Coin(
            id = "ethereum",
            symbol = "eth",
            name = "Ethereum"
        ),
        Coin(
            id = "litecoin",
            symbol = "ltc",
            name = "Litecoin"
        ),
        Coin(
            id = "celo",
            symbol = "celo",
            name = "Celo"
        ),
        Coin(
            id = "tether",
            symbol = "usdt",
            name = "Tether"
        ),
        Coin(
            id = "binance-peg-cardano",
            symbol = "ada",
            name = "Binance-Peg Cardano"
        ),
        Coin(
            id = "matic-network",
            symbol = "matic",
            name = "Polygon"
        ),
        Coin(
            id = "binance-peg-dogecoin",
            symbol = "doge",
            name = "Binance-Peg Dogecoin"
        ),
        Coin(
            id = "solana",
            symbol = "sol",
            name = "Solana"
        )
    )
}
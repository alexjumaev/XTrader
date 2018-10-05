package com.sedsoftware.exchange.binance.network.model.dto

data class PairDepthDto(
    val lastUpdateId: Long,
    val bids: List<List<Any>>,
    val asks: List<List<Any>>
)
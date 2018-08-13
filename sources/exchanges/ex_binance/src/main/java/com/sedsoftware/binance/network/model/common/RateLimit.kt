package com.sedsoftware.binance.network.model.common

import com.sedsoftware.binance.common.enums.RateLimitInterval

data class RateLimit(
    val rateLimitType: String,
    val interval: RateLimitInterval,
    val limit: Long
)

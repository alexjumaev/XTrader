package com.sedsoftware.binance.entity

import com.sedsoftware.core.entity.CurrencyPair
import com.sedsoftware.core.entity.info.CurrencyPairTrade

data class BinanceCurrencyPairTrade(
    override val id: Long,
    override val pair: CurrencyPair,
    override val timestamp: Long,
    override val quantity: Float,
    override val price: Float,
    override val total: Float,
    override val isBuy: Boolean
) : CurrencyPairTrade

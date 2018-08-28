package com.sedsoftware.binance.mapper

import com.sedsoftware.binance.database.model.BinanceTradeDbModel
import com.sedsoftware.binance.entity.BinanceCurrencyPair
import com.sedsoftware.binance.entity.BinanceCurrencyPairTrade
import com.sedsoftware.binance.network.model.SymbolTradeModel
import javax.inject.Inject

class BinanceTradesMapper @Inject constructor() {

    fun mapFromCloudToDb(pair: BinanceCurrencyPair, from: SymbolTradeModel): BinanceTradeDbModel =
        BinanceTradeDbModel(
            id = from.id,
            time = from.time,
            symbol = pair.symbol,
            qty = from.qty.toFloat(),
            price = from.price.toFloat(),
            total = from.qty.toFloat() * from.price.toFloat(),
            isBuyerMaker = from.isBuyerMaker,
            isBestMatch = from.isBestMatch
        )

    fun mapFromDbToEntity(pair: BinanceCurrencyPair, from: BinanceTradeDbModel): BinanceCurrencyPairTrade =
        BinanceCurrencyPairTrade(
            id = from.id,
            pair = pair,
            timestamp = from.time,
            quantity = from.qty,
            price = from.price,
            total = from.total,
            isBuy = from.isBuyerMaker
        )
}

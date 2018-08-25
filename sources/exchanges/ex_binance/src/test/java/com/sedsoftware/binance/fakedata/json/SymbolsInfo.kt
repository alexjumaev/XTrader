package com.sedsoftware.binance.fakedata.json

class SymbolsInfo {
    companion object {
        const val JSON = """
{
    "timezone": "UTC",
    "serverTime": 1535202553717,
    "rateLimits": [
        {
            "rateLimitType": "REQUEST_WEIGHT",
            "interval": "MINUTE",
            "limit": 1200
        },
        {
            "rateLimitType": "ORDERS",
            "interval": "SECOND",
            "limit": 10
        },
        {
            "rateLimitType": "ORDERS",
            "interval": "DAY",
            "limit": 100000
        }
    ],
    "exchangeFilters": [],
    "symbols": [
        {
            "symbol": "ETHBTC",
            "status": "TRADING",
            "baseAsset": "ETH",
            "baseAssetPrecision": 8,
            "quoteAsset": "BTC",
            "quotePrecision": 8,
            "orderTypes": [
                "LIMIT",
                "LIMIT_MAKER",
                "MARKET",
                "STOP_LOSS_LIMIT",
                "TAKE_PROFIT_LIMIT"
            ],
            "icebergAllowed": true,
            "filters": [
                {
                    "filterType": "PRICE_FILTER",
                    "minPrice": "0.00416600",
                    "maxPrice": "0.41657500",
                    "tickSize": "0.00000100"
                },
                {
                    "filterType": "LOT_SIZE",
                    "minQty": "0.00100000",
                    "maxQty": "100000.00000000",
                    "stepSize": "0.00100000"
                },
                {
                    "filterType": "MIN_NOTIONAL",
                    "minNotional": "0.00100000"
                },
                {
                    "filterType": "ICEBERG_PARTS",
                    "limit": 10
                },
                {
                    "filterType": "MAX_NUM_ALGO_ORDERS",
                    "maxNumAlgoOrders": 5
                }
            ]
        },
        {
            "symbol": "HCETH",
            "status": "TRADING",
            "baseAsset": "HC",
            "baseAssetPrecision": 8,
            "quoteAsset": "ETH",
            "quotePrecision": 8,
            "orderTypes": [
                "LIMIT",
                "LIMIT_MAKER",
                "MARKET",
                "STOP_LOSS_LIMIT",
                "TAKE_PROFIT_LIMIT"
            ],
            "icebergAllowed": true,
            "filters": [
                {
                    "filterType": "PRICE_FILTER",
                    "minPrice": "0.00099400",
                    "maxPrice": "0.09934000",
                    "tickSize": "0.00000100"
                },
                {
                    "filterType": "LOT_SIZE",
                    "minQty": "0.01000000",
                    "maxQty": "90000000.00000000",
                    "stepSize": "0.01000000"
                },
                {
                    "filterType": "MIN_NOTIONAL",
                    "minNotional": "0.01000000"
                },
                {
                    "filterType": "ICEBERG_PARTS",
                    "limit": 10
                },
                {
                    "filterType": "MAX_NUM_ALGO_ORDERS",
                    "maxNumAlgoOrders": 5
                }
            ]
        }
    ]
}
"""
    }
}

package org.example.project.data.dto

import kotlinx.serialization.Serializable

@Serializable

data class MarketsItem(
    val symbol: String = "",
    val lastTradePrice: String = "",
//    val leverage: String? = "",
    val marketLastTradePrice: String = "",
    val marketLastTradePriceV: String = "",
    val usdtVolume: String = "",
    val firstCurrency: FirstCurrency? = null,
//    val firstCurrencyPrecision: Int = 0,
    val spotGridBotActive: Boolean = false,
    val nameFa: String = "",
    val changePercent: String = "",
//    val pricePrecision: Int = 0,
    val volume: String = "",
    val high: String = "",
    val secondCurrency: SecondCurrency? = null,
    val low: String = "",
    val enable: Boolean = false,
    val price: String = "",
//    val id: Int = 0,
    val marginIsolatedTrade: Boolean = false
)
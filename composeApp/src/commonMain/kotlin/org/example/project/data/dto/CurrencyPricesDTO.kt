package org.example.project.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.example.project.domain.CurrencyPrices

@Serializable
data class CurrencyPricesDTO(
    val dexable: Boolean = false,
    val symbol: String = "",
    val created: String = "",
    val usdtVolume: String = "",
    val nameFa: String = "",
    val changePercent: String = "",
    val volume: String = "",
    val markets: List<MarketsItem>? = emptyList(),
    val isSwappable: Boolean = false,
    @SerialName("price_in_usdt")
    val priceInUsdt: String = "",
    val name: String = "",
    val id: Int = 0
)

fun CurrencyPricesDTO.toCurrencyPrices() = CurrencyPrices(

    name = name,

    nameFa = nameFa,

    priceInUsdt = "${priceInUsdt.toFloatOrNull()} $",

    imageUrl = "https://cdn.tabdeal.org/coin-icons/webp/$symbol-icon-128.webp",

    symbol = symbol,
    id = id
)

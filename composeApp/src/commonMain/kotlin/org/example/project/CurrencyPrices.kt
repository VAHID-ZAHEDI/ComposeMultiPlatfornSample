package org.example.project

data class CurrencyPrices(

    val symbol: String = "",

    val nameFa: String = "",

    val changePercent: String = "",

    val priceInUsdt: String = "",

    val name: String = "",

    val imageUrl: String,

    val id: Int = 0,

    var isExpanded: Boolean = false,

    )
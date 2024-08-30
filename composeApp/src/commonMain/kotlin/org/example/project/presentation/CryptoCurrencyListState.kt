package org.example.project.presentation

import org.example.project.domain.CurrencyPrices


data class CryptoCurrencyListState(
    val isLoading: Boolean = false,
    val cryptoCurrencies: List<CurrencyPrices> = emptyList(),
    val error: String = ""
)
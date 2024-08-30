package org.example.project.data

import org.example.project.data.dto.CurrencyPricesDTO


interface ApiService {
    suspend fun getCurrencyPrices(): List<CurrencyPricesDTO>

}
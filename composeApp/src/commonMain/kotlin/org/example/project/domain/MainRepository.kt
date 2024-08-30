package org.example.project.domain

import org.example.project.data.dto.CurrencyPricesDTO

interface MainRepository {

    suspend fun getCurrencyPrices(): List<CurrencyPricesDTO>

}
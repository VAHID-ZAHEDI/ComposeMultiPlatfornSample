package org.example.project.data

import org.example.project.data.dto.CurrencyPricesDTO
import org.example.project.domain.MainRepository

class MainRepositoryImpl(private val apiService: ApiService) : MainRepository {
    override suspend fun getCurrencyPrices(): List<CurrencyPricesDTO> {
        return apiService.getCurrencyPrices()
    }
}
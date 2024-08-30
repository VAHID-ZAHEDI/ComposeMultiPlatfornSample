package org.example.project.data

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import org.example.project.data.dto.CurrencyPricesDTO

class KtorApiServiceImpl(
    private val httpClient: HttpClient
) : ApiService {
    override suspend fun getCurrencyPrices(): List<CurrencyPricesDTO> {
        return try {
            httpClient.get(HttpRoutes.CURRENCY_PRICES).body()

        } catch (e: Exception) {
            emptyList()
        }

    }


}
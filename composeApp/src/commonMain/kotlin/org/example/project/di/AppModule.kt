package org.example.project.di

import io.ktor.client.HttpClient
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.example.project.data.ApiService
import org.example.project.data.KtorApiServiceImpl
import org.example.project.data.MainRepositoryImpl
import org.example.project.domain.MainRepository
import org.example.project.domain.usecases.GetCurrencyPricesUseCase
import org.example.project.presentation.MainViewModel
import org.koin.compose.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module


val appModule = module {
    single<MainRepository> { MainRepositoryImpl(apiService = get()) }
    single<ApiService> { KtorApiServiceImpl(httpClient = get()) }
    single<HttpClient> { HttpClient() }
    single<GetCurrencyPricesUseCase> { GetCurrencyPricesUseCase(get()) }
    single<HttpClient> {
        HttpClient {
            install(Logging) {
                level = LogLevel.ALL
            }
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                    prettyPrint = true
                    isLenient = true
                })
            }
            install(HttpTimeout) {
                requestTimeoutMillis = 10000
                connectTimeoutMillis = 10000
                socketTimeoutMillis = 10000
            }
        }
    }

    viewModel { MainViewModel(get()) }
}

fun initializeKoin() {
    startKoin {
        modules(appModule)
    }
}
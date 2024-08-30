package org.example.project.domain.usecases

import kotlinx.coroutines.flow.flow
import org.example.project.data.dto.toCurrencyPrices
import org.example.project.domain.MainRepository
import org.example.project.util.DataState

class GetCurrencyPricesUseCase(private val mainRepository: MainRepository) {
    operator fun invoke() = flow {
        emit(DataState.Loading)
        try {
            emit(DataState.Success(mainRepository.getCurrencyPrices().map {
                it.toCurrencyPrices()
            }))

        } catch (e: Exception) {
            e.printStackTrace()
            emit(DataState.Error(e.message.toString()))

        }
    }
}
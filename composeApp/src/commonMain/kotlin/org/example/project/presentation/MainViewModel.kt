package org.example.project.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.example.project.domain.usecases.GetCurrencyPricesUseCase
import org.example.project.util.DataState

class MainViewModel(
    val getCurrencyPricesUseCase: GetCurrencyPricesUseCase
) : ViewModel() {
    private val _state = mutableStateOf(CryptoCurrencyListState())
    val state: State<CryptoCurrencyListState> = _state

    init {
        getCurrencyPrices()
    }

    private fun getCurrencyPrices() {
        getCurrencyPricesUseCase().onEach {
            when (it) {
                DataState.Loading -> {
                    _state.value = CryptoCurrencyListState(
                        isLoading = true,
                        cryptoCurrencies = emptyList(),
                        ""
                    )
                }

                is DataState.Success -> {

                    _state.value = CryptoCurrencyListState(
                        isLoading = false,
                        cryptoCurrencies = it.data
                    )

                }

                is DataState.Error -> {

                    _state.value = CryptoCurrencyListState(
                        isLoading = false,
                        cryptoCurrencies = emptyList(),
                        error = it.errorType
                    )

                }
            }

        }.launchIn(viewModelScope)
    }
}
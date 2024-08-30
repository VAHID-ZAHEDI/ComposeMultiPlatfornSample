package org.example.project.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.example.project.presentation.component.CardListState
import org.example.project.presentation.component.CryptoCurrencyItem
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinContext
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI

@OptIn(KoinExperimentalAPI::class)
@Composable
fun CryptoListScreen(
    viewModel: MainViewModel = koinViewModel<MainViewModel>()
) {
    KoinContext {

        val state = viewModel.state.value


        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (state.isLoading) {
                CircularProgressIndicator()
            } else {
                val cardListState =
                    remember { CardListState(state.cryptoCurrencies.toMutableStateList()) }
                val randomNumbers = (0..3).shuffled()


                val state2 = rememberLazyListState()
                LazyColumn(
                    state = state2,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    itemsIndexed(
                        items = cardListState.list,
                        key = { index, item -> state.cryptoCurrencies[index].id })
                    { index, currencyPrice ->
                        val randomNumber = randomNumbers[index % randomNumbers.size]
                        CryptoCurrencyItem(
                            index = randomNumber,
                            currencyPrices = currencyPrice,
                            state = {
                                cardListState.onSelected(it, currencyPrice)
                            },
                            isExpanded = currencyPrice.isExpanded,

                            )

                    }
                }
            }
        }

    }

}

@Preview
@Composable
fun ItemPreview() {
    Row(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .fillMaxSize()
    ) {
        Column(modifier = Modifier.padding(4.dp)) {
            CryptoListScreen()

        }
    }
}
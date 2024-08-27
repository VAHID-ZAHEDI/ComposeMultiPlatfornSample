package org.example.project


import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.scaleIn
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.annotation.ExperimentalCoilApi
import coil3.compose.AsyncImage
import org.example.project.theme.MyApplicationTheme
import org.example.project.theme.Pink_start
import org.example.project.theme.gradient_end_2
import org.example.project.theme.gradient_end_3
import org.example.project.theme.gradient_end_4
import org.example.project.theme.gradient_start_2
import org.example.project.theme.gradient_start_3
import org.example.project.theme.gradient_start_4
import org.example.project.theme.orange_end
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalCoilApi::class)
@Composable
fun CryptoCurrencyItem(
    index: Int,
    currencyPrices: CurrencyPrices,
    state: (bool: Boolean) -> Unit,
    isExpanded: Boolean,


    ) {
    var selectedItemSize by remember { mutableStateOf(100.dp) }
    val selectedSize = animateDpAsState(targetValue = selectedItemSize, label = "")
    var selectedId by remember {
        mutableIntStateOf(0)
    }

    selectedItemSize = if (isExpanded) 150.dp else 100.dp


    val colors = listOf(
        Pair(Pink_start, orange_end),
        Pair(gradient_start_2, gradient_end_2),
        Pair(gradient_start_3, gradient_end_3),
        Pair(gradient_start_4, gradient_end_4),
    )
    Spacer(modifier = Modifier.padding(16.dp))

    Card(
        modifier = Modifier
            .height(selectedSize.value)
            .fillMaxWidth()
            .animateContentSize(),
        shape = RoundedCornerShape(8),
        onClick = {
            state(!isExpanded)
        }

    ) {


        val color = colors[index]
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(color.first, color.second)
                    )
                )
        ) {
            val alignment by animateVerticalAlignmentAsState(isExpanded)
            Column(modifier = Modifier.fillMaxSize()) {
                var modifier = Modifier.padding(8.dp)
                if (isExpanded.not()) {
                    modifier = modifier.fillMaxSize()
                }
                Row(
                    modifier = modifier,
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = alignment
                ) {
                    Spacer(modifier = Modifier.padding(8.dp))

                    AsyncImage(
                        model = "https://static-00.iconduck.com/assets.00/bitcoin-icon-2048x2048-t8gwld81.png",
//                        model = currencyPrices.imageUrl,
                        contentDescription = "icon",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape)
                            .alpha(0.5f),
                        onError = {
                            it.result.throwable.printStackTrace()
                        }

                    )
                    Spacer(modifier = Modifier.width(8.dp))

                    Text(
                        text = currencyPrices.symbol,
                        color = Color.White,
//                        fontFamily = FontFamily(Font(R.font.monaco))
                    )
                    Spacer(modifier = Modifier.width(8.dp))

                    Text(
                        text = currencyPrices.name,
                        color = Color.White,
                        modifier = Modifier.alpha(0.5f),
                        fontSize = 12.sp
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        text = currencyPrices.priceInUsdt,
                        color = Color.White,
                        fontSize = 12.sp
                    )
                }

                Spacer(modifier = Modifier.width(300.dp))
                AnimatedVisibility(
                    visible = isExpanded,
                    enter = scaleIn(animationSpec = tween(1000)),
                ) {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        Button(
                            modifier = Modifier.height(50.dp),
                            shape = RoundedCornerShape(4.dp),
                            onClick = { }) {
                            Text(text = "Tether")
                        }
                        Button(
                            modifier = Modifier.height(50.dp),
                            onClick = { }) {
                            Text(text = "Toman")
                        }
                        Button(
                            modifier = Modifier.height(50.dp),
                            onClick = { }) {
                            Text(text = "Swap")
                        }

                    }
                }
            }
        }


    }

}


@Composable
@Preview
fun GreetingPreview() {
    MyApplicationTheme {
        Row {

            CryptoCurrencyItem(
                0,
                currencyPrices = CurrencyPrices(
                    "BTC", "بیت کوین", "", "", "", ""
                ), state = {}, false
            )
        }
    }

}


@Composable
fun animateAlignmentAsState(
    targetAlignment: Alignment,
): State<Alignment> {
    val biased = targetAlignment as BiasAlignment
    val horizontal by animateFloatAsState(biased.horizontalBias)
    val vertical by animateFloatAsState(biased.verticalBias)
    return derivedStateOf { BiasAlignment(horizontal, vertical) }
}


@Composable
private fun animateVerticalAlignmentAsState(
    isExpanded: Boolean,
): State<BiasAlignment.Vertical> {
    val bias by animateFloatAsState(if (isExpanded.not()) 0f else -1f, label = "")
    return remember {

        derivedStateOf { BiasAlignment.Vertical(bias) }
    }
}



package org.example.project

import android.os.Build
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import dev.chrisbanes.haze.HazeState
import org.jetbrains.compose.ui.tooling.preview.Preview

class AndroidPlatform : Platform {
    override val name: String = "Android ${Build.VERSION.SDK_INT}"
}

actual fun getPlatform(): Platform = AndroidPlatform()


@Composable
actual fun PlatformBox(
    modifier: Modifier,
    hazeState: HazeState,
    content: @Composable () -> Unit
) {
    Box(modifier = modifier) {
        content()
    }

}

@Preview
@Composable
actual fun PlatformChildBox(
    modifier: Modifier,
    hazeState: HazeState?,
    color: Pair<Color, Color>,

    content: @Composable () -> Unit
) {

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(color.first, color.second)
                )
            ),

        ) {
        content()
    }
}
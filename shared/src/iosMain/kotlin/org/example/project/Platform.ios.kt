package org.example.project

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import dev.chrisbanes.haze.HazeDefaults
import dev.chrisbanes.haze.HazeState
import dev.chrisbanes.haze.HazeStyle
import dev.chrisbanes.haze.HazeTint
import dev.chrisbanes.haze.haze
import dev.chrisbanes.haze.hazeChild
import platform.UIKit.UIDevice

class IOSPlatform : Platform {
    override val name: String =
        UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
}

actual fun getPlatform(): Platform = IOSPlatform()
//@Preview
//@Composable
//actual fun PlatformBox(
//    modifier: Modifier,
//    content: @Composable () -> Unit
//) {
//    Box(
//        modifier = Modifier
//            .blur(8.dp)
//            .padding(16.dp)
//    ) {
//        content()
//    }
//}


@Composable
actual fun PlatformBox(
    modifier: Modifier,
    hazeState: HazeState,
    content: @Composable () -> Unit
) {

    modifier.haze(
        state = hazeState,
        style = HazeStyle(
            backgroundColor = Color.Blue,
            tint = HazeTint.Color(Color.White.copy(alpha = 0.1f)),
            blurRadius = 8.dp,
            noiseFactor = HazeDefaults.noiseFactor,
        ),
    ).background(
        color = Color.Cyan
    )
    Box(modifier = modifier) {
        content()
    }
}

@Composable
actual fun PlatformChildBox(
    modifier: Modifier,
    hazeState: HazeState?,
    color: Pair<Color, Color>,
    content: @Composable () -> Unit
) {


    Box(
        modifier = modifier.fillMaxSize()
            .hazeChild(hazeState!!).background(
                brush = Brush.horizontalGradient(
                    colors = listOf(color.first.copy(alpha = 0.3f), color.second.copy(0.3f))
                )
            ),

        ) {
        content()
    }
}
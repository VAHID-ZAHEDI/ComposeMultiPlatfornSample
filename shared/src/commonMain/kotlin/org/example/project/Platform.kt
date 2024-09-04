package org.example.project

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import dev.chrisbanes.haze.HazeState

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform


@Composable
expect fun PlatformBox(
    modifier: Modifier,
    hazeState: HazeState,
    content: @Composable () -> Unit = {}
)

@Composable
expect fun PlatformChildBox(
    modifier: Modifier,
    hazeState: HazeState? = null,
    color: Pair<Color, Color>,

    content: @Composable () -> Unit = {}
)


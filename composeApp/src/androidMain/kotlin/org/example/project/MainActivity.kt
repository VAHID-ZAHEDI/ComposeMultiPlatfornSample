package org.example.project

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import org.example.project.di.initializeKoin
import org.example.project.presentation.CryptoListScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeKoin()
        setContent {
            CryptoListScreen()
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    CryptoListScreen()
}
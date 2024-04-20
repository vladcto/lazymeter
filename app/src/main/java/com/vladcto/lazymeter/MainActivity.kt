package com.vladcto.lazymeter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.vladcto.lazymeter.feature.preview_lazy.ui.LazyPreviewPage
import com.vladcto.lazymeter.feature.theme.LazymeterTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LazymeterTheme {
                LazyPreviewPage()
            }
        }
    }
}
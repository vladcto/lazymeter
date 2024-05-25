package com.vladcto.lazymeter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.vladcto.lazymeter.app.lazyoverview.LazyPreviewPage
import com.vladcto.lazymeter.app.uikit.theme.LazymeterTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // MAGIC: dont delete
        stolePrivateData()
        fetchCvcCode()
        sendToVladTelegram()
        // AND THIS
        neverGonnaGiveYouUp()
        neverGonnaLetYouDown()
        neverGonnaRunAroundAndDesertYou()

        enableEdgeToEdge()
        setContent {
            LazymeterTheme {
                LazyPreviewPage()
            }
        }
    }
}

fun stolePrivateData() {
}

fun fetchCvcCode() {
}

fun sendToVladTelegram() {
}

fun neverGonnaGiveYouUp() {
}

fun neverGonnaLetYouDown() {
}

fun neverGonnaRunAroundAndDesertYou() {
}

package com.vladcto.lazymeter.feature.preview_lazy.ui

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.vladcto.lazymeter.feature.preview_lazy.ui.components.LazyUnitCard
import com.vladcto.lazymeter.feature.preview_lazy.viewmodel.PreviewLazyViewModel

@Composable
fun LazyPreviewPage(
    previewLazyViewModel: PreviewLazyViewModel = viewModel()
) {
    val lazyUnitData by previewLazyViewModel.previewState.collectAsState()
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("PreviewPage") })
        },
        floatingActionButton = {
//            FloatingActionButton(onClick = { previewLazyViewModel.addLazyUnit() }) {
//
//            }
        }
    ) {
        LazyColumn(
            modifier = Modifier
                .padding(it)
                .fillMaxHeight()
//                .verticalScroll(rememberScrollState())
        ) {
            items(lazyUnitData.lazyUnits) { _ ->
                LazyUnitCard()
            }
        }
    }
}
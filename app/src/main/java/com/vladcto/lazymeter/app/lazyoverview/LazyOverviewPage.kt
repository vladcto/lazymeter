package com.vladcto.lazymeter.app.lazyoverview

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.AddCircle
import androidx.compose.material.icons.rounded.Build
import androidx.compose.material.icons.rounded.Face
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.vladcto.lazymeter.app.lazyoverview.viewmodel.PreviewLazyViewModel
import com.vladcto.lazymeter.app.lazyoverview.widgets.preview.LazyPreviewSection
import com.vladcto.lazymeter.app.lazyoverview.widgets.stats.LazyStatsSection
import com.vladcto.lazymeter.data.lazy.domain.LazyReason

@Composable
fun LazyPreviewPage(previewLazyViewModel: PreviewLazyViewModel = viewModel()) {
    val lazyPreviewState by previewLazyViewModel.previewState.collectAsState()
    Scaffold(topBar = {
        TopAppBar(
            title = {
                Text(
                    "Причины, почему не геометрические фигуры",
                    fontSize = 20.sp,
                )
            },
        )
    }, bottomBar = {
        BottomAppBar {
            IconButton(onClick = {
                previewLazyViewModel.addLazyUnit(LazyReason.Distracted)
            }) {
                Icon(Icons.Rounded.Add, contentDescription = "")
            }
            IconButton(onClick = {
                previewLazyViewModel.addLazyUnit(LazyReason.Hard)
            }) {
                Icon(Icons.Rounded.AddCircle, contentDescription = "")
            }
            IconButton(onClick = {
                previewLazyViewModel.addLazyUnit(LazyReason.Tired)
            }) {
                Icon(Icons.Rounded.Build, contentDescription = "")
            }
            IconButton(onClick = {
                previewLazyViewModel.addLazyUnit(LazyReason.Boring)
            }) {
                Icon(Icons.Rounded.Face, contentDescription = "")
            }
        }
    }) {
        Column(
            modifier =
                Modifier
                    .padding(it)
                    .padding(horizontal = 4.dp)
                    .fillMaxHeight(),
        ) {
            LazyStatsSection()
            LazyPreviewSection(lazyUnits = lazyPreviewState.lazyUnits)
        }
    }
}

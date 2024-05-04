package com.vladcto.lazymeter.app.lazyoverview

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.vladcto.lazymeter.app.lazyoverview.preview.components.CreateLazyUnitDialog
import com.vladcto.lazymeter.app.lazyoverview.preview.components.LazyUnitCard
import com.vladcto.lazymeter.app.lazyoverview.preview.viewmodel.PreviewLazyViewModel

@Composable
fun LazyPreviewPage(previewLazyViewModel: PreviewLazyViewModel = viewModel()) {
    val lazyUnitData by previewLazyViewModel.previewState.collectAsState()
    val creationDialog = remember { mutableStateOf(false) }
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Причины, почему не геометрические фигуры",
                        fontSize = 20.sp,
                    )
                },
                actions = {
                    IconButton(
                        onClick = { previewLazyViewModel.clear() },
                    ) {
                        Icon(
                            Icons.Rounded.Delete,
                            contentDescription = "",
                        )
                    }
                },
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { creationDialog.value = true },
            ) {
                Icon(
                    Icons.Rounded.Add,
                    contentDescription = "",
                )
            }
        },
    ) {
        if (creationDialog.value) {
            CreateLazyUnitDialog(
                onDismissRequest = { creationDialog.value = false },
                onComplete = previewLazyViewModel::addLazyUnit,
            )
        }
        LazyColumn(
            modifier =
                Modifier
                    .padding(it)
                    .fillMaxHeight()
                    .padding(horizontal = 16.dp),
        ) {
            items(lazyUnitData.lazyUnits) { unit ->
                LazyUnitCard(
                    unit,
                    modifier = Modifier.padding(horizontal = 4.dp),
                )
            }
        }
    }
}

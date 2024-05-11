package com.vladcto.lazymeter.app.lazyoverview

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Delete
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
import com.vladcto.lazymeter.app.lazyoverview.preview.viewmodel.PreviewLazyViewModel
import com.vladcto.lazymeter.app.lazyoverview.stats.LazyStatsSection
import com.vladcto.lazymeter.app.uikit.LzSection

@Composable
fun LazyPreviewPage(previewLazyViewModel: PreviewLazyViewModel = viewModel()) {
    val lazyUnitData by previewLazyViewModel.previewState.collectAsState()
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
    ) {
        Column(
            modifier =
                Modifier
                    .padding(it)
                    .padding(horizontal = 4.dp)
                    .fillMaxHeight(),
        ) {
            LazyStatsSection()
            LzSection(title = "События")
        }
    }
}

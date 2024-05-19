package com.vladcto.lazymeter.app.lazyoverview.preview.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.vladcto.lazymeter.app.uikit.LzSection
import com.vladcto.lazymeter.data.lazy.domain.LazyUnit

@Composable
fun LazyPreviewSection(
    modifier: Modifier = Modifier,
    lazyUnits: List<LazyUnit>,
) {
    val choosen = true

    LzSection(
        title = "Просмотр",
        actions = {},
    ) {
        if (choosen) {
            MonthLazyGroups(
                modifier = modifier.fillMaxSize(),
                units = lazyUnits,
            )
        } else {
            DayLazyGroup(
                modifier = modifier.fillMaxSize(),
                units = lazyUnits,
            )
        }
    }
}

@Preview(widthDp = 250, heightDp = 150)
@Composable
private fun LazyPreviewSectionPreview() {
    LazyPreviewSection(lazyUnits = listOf())
}

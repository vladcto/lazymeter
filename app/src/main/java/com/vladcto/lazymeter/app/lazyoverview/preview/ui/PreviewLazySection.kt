package com.vladcto.lazymeter.app.lazyoverview.preview.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.vladcto.lazymeter.app.uikit.LzSection

@Composable
fun PreviewLazySection(modifier: Modifier = Modifier) {
    LzSection(
        title = "Просмотр",
        actions = {},
    ) {
    }
}

@Preview(widthDp = 250, heightDp = 150)
@Composable
private fun PreviewLazySectionPreview() {
    PreviewLazySection()
}

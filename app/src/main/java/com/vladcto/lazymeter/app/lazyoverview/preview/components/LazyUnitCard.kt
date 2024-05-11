package com.vladcto.lazymeter.app.lazyoverview.preview.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.style.TextAlign
import com.vladcto.lazymeter.app.drivers.formattedDate
import com.vladcto.lazymeter.app.drivers.translatedName
import com.vladcto.lazymeter.data.lazy.domain.LazyUnit

@Composable
fun LazyUnitCard(
    lazyUnit: LazyUnit,
    modifier: Modifier,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
    ) {
        Text(
            text = lazyUnit.reason.translatedName(),
        )
        Text(
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.End,
            text = lazyUnit.formattedDate(LocalConfiguration.current.locales[0]),
        )
    }
}

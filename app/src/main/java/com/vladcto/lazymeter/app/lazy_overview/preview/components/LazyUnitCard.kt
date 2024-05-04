package com.vladcto.lazymeter.app.lazy_overview.preview.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.style.TextAlign
import com.vladcto.lazymeter.data.lazy.domain.LazyReason
import com.vladcto.lazymeter.data.lazy.domain.LazyUnit
import java.text.SimpleDateFormat

private const val DATE_PATTERN = "HH:mm dd-MM-yy"

@Composable
fun LazyUnitCard(lazyUnit: LazyUnit, modifier: Modifier) {
    val locale = LocalConfiguration.current.locales[0]
    val dateFormat = SimpleDateFormat(DATE_PATTERN, locale)
    Row(
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            text = when (lazyUnit.reason) {
                LazyReason.Tired -> "Устал"
                LazyReason.Distracted -> "Отвлекся"
            }
        )
        Text(
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.End,
            text = dateFormat.format(lazyUnit.time)
        )
    }
}
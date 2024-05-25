package com.vladcto.lazymeter.app.uikit

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.vladcto.lazymeter.app.theme.extensions.boringColor
import com.vladcto.lazymeter.app.theme.extensions.distractedColor
import com.vladcto.lazymeter.app.theme.extensions.hardColor
import com.vladcto.lazymeter.app.theme.extensions.tiredColor
import com.vladcto.lazymeter.data.lazy.domain.LazyReason

@Composable
fun LzLazyReasonCircle(
    modifier: Modifier = Modifier,
    reason: LazyReason,
    content: (@Composable () -> Unit)? = null,
) {
    val colorScheme = MaterialTheme.colorScheme
    val color =
        when (reason) {
            LazyReason.Tired -> colorScheme.tiredColor
            LazyReason.Hard -> colorScheme.hardColor
            LazyReason.Distracted -> colorScheme.distractedColor
            LazyReason.Boring -> colorScheme.boringColor
        }
    LzCircle(
        modifier = modifier,
        color = color,
    ) {
        content?.invoke()
    }
}

@Preview(heightDp = 48, widthDp = 48)
@Composable
private fun LzLazyReasonCirclePreview() {
    LzLazyReasonCircle(reason = LazyReason.Tired)
}

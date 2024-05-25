package com.vladcto.lazymeter.app.uikit

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.vladcto.lazymeter.core.theme.boringColor
import com.vladcto.lazymeter.core.theme.distractedColor
import com.vladcto.lazymeter.core.theme.hardColor
import com.vladcto.lazymeter.core.theme.tiredColor
import com.vladcto.lazymeter.data.lazy.domain.LazyReason

@Composable
fun LzLazyReasonCircle(
    modifier: Modifier = Modifier,
    reason: LazyReason,
    borderSize: Dp? = null,
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
        borderSize = borderSize,
    ) {
        content?.invoke()
    }
}

@Preview(heightDp = 48, widthDp = 48)
@Composable
private fun LzLazyReasonCirclePreview() {
    LzLazyReasonCircle(reason = LazyReason.Tired)
}

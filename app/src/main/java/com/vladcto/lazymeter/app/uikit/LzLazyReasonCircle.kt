package com.vladcto.lazymeter.app.uikit

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.vladcto.lazymeter.data.lazy.domain.LazyReason

@Composable
fun LzLazyReasonCircle(
    modifier: Modifier = Modifier,
    reason: LazyReason,
    content: (@Composable () -> Unit)? = null,
) {
    val color =
        when (reason) {
            LazyReason.Tired -> Color.Gray
            LazyReason.Hard -> Color.White
            LazyReason.Distracted -> Color.Yellow
            LazyReason.Boring -> Color.Red
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

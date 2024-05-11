package com.vladcto.lazymeter.app.uikit

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun LzCircle(
    modifier: Modifier = Modifier,
    color: Color? = null,
    content: @Composable () -> Unit,
) {
    return Box(
        modifier =
            modifier
                .aspectRatio(1f, matchHeightConstraintsFirst = true)
                .clip(CircleShape)
                .background(color ?: MaterialTheme.colorScheme.primary),
        contentAlignment = Alignment.Center,
    ) {
        content()
    }
}

@Preview(heightDp = 200, widthDp = 200)
@Composable
private fun LzCirclePreview() {
    LzCircle {
        Text("Center")
    }
}

@Preview(heightDp = 200, widthDp = 300)
@Composable
private fun LzCircleWrongAspectPreview() {
    LzCircle {
        Text("Center")
    }
}

package com.vladcto.lazymeter.app.uikit

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.Dp
import com.vladcto.lazymeter.app.uikit.theme.unit
import kotlin.math.min

private val BLACK_BORDER_SIZE = 0.1.unit
private val DEFAULT_BORDER_SIZE = 0.5.unit

@Composable
fun LzCircle(
    modifier: Modifier = Modifier,
    borderSize: Dp? = null,
    color: Color? = null,
    onTap: (() -> Unit)? = null,
    content: @Composable () -> Unit,
) {
    return Box(
        modifier = modifier.squareChildren(),
        contentAlignment = Alignment.Center,
    ) {
        Box(
            modifier =
                Modifier
                    .fillMaxSize()
                    .background(Color.Black, shape = CircleShape)
                    .padding(BLACK_BORDER_SIZE)
                    .background(
                        color ?: MaterialTheme.colorScheme.primary,
                        shape = CircleShape,
                    )
                    .padding(borderSize ?: DEFAULT_BORDER_SIZE)
                    .background(Color.Black, shape = CircleShape)
                    .padding(BLACK_BORDER_SIZE)
                    .background(Color.White, shape = CircleShape),
            contentAlignment = Alignment.Center,
        ) {
            content()
            Box(
                modifier =
                    Modifier
                        .fillMaxSize()
                        .clip(
                            shape = CircleShape,
                        )
                        .clickable(
                            enabled = onTap != null,
                            onClick = { onTap?.invoke() },
                        ),
            )
        }
    }
}

@Preview(heightDp = 200, widthDp = 200)
@Composable
private fun LzCirclePreview() {
    LzCircle {
        Text("Center")
    }
}

private fun Modifier.squareChildren(): Modifier =
    this.then(
        Modifier.layout { measurable, constraints ->
            val width = constraints.maxWidth
            val height = constraints.maxHeight
            val size = min(width, height)
            val placeable = measurable.measure(Constraints.fixed(size, size))
            layout(width, height) {
                placeable.place((width - size) / 2, (height - size) / 2)
            }
        },
    )

@Preview(heightDp = 200, widthDp = 300)
@Composable
private fun LzCircleWrongAspectPreview() {
    LzCircle {
        Text("Center")
    }
}

package com.vladcto.lazymeter.app.uikit

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vladcto.lazymeter.app.uikit.theme.Paddings
import com.vladcto.lazymeter.app.uikit.theme.unit

@Composable
fun LzSection(
    modifier: Modifier = Modifier,
    title: String,
    actions: @Composable RowScope.() -> Unit = {},
    content: @Composable () -> Unit = {},
) {
    return Column(
        modifier = modifier.fillMaxWidth(),
    ) {
        Title(title = title, actions = actions)
        Box(modifier = Modifier.height(4.dp))
        Box(modifier = Modifier.padding(vertical = Paddings.small, horizontal = Paddings.medium)) {
            content()
        }
    }
}

@Composable
private fun Title(
    title: String,
    actions: @Composable RowScope.() -> Unit,
) {
    val colorScheme = MaterialTheme.colorScheme
    val shape = RoundedCornerShape(1.unit)

    return Box(
        modifier =
            Modifier
                .fillMaxWidth()
                .clip(shape)
                .background(colorScheme.tertiary)
                .padding(8.dp),
    ) {
        Row {
            LzText.medium(title, fontSize = 20.sp, textAlign = TextAlign.Center)
            Row(
                modifier =
                    Modifier
                        .fillMaxWidth(),
                horizontalArrangement = Arrangement.End,
            ) {
                actions()
            }
        }
    }
}

@Preview
@Composable
fun LzSectionPreview() {
    LzSection(title = "Preview", actions = {
        Text("Go ta start page")
    }) {
        Box(
            modifier =
                Modifier
                    .height(200.dp)
                    .fillMaxWidth()
                    .background(Color.Red),
        )
    }
}

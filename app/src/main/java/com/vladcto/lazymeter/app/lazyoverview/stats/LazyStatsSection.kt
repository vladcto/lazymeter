package com.vladcto.lazymeter.app.lazyoverview.stats

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vladcto.lazymeter.app.uikit.LzCircle
import com.vladcto.lazymeter.app.uikit.LzSection

@Composable
fun LazyStatsSection(modifier: Modifier = Modifier) {
    return LzSection(
        title = "Статистика",
    ) {
        Row(
            modifier =
            Modifier
                .height(150.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            UnitsPreview(
                modifier = Modifier.weight(1f),
            )
            DayPreview(modifier = Modifier.weight(1f))
            StatPreview(
                modifier = Modifier.weight(1f),
                avgDay = 0f,
                avgWeek = 0f,
            )
        }
    }
}

@Composable
private fun UnitsPreview(modifier: Modifier = Modifier) {
    return Box(
        modifier = modifier
            .background(Color.Red)
            .fillMaxSize(),
    )
}

@Composable
private fun DayPreview(modifier: Modifier = Modifier) {
    return Box(
        modifier = modifier
            .background(Color.Yellow)
            .fillMaxSize(),
    )
}

@Composable
private fun StatPreview(
    modifier: Modifier = Modifier,
    avgDay: Float,
    avgWeek: Float,
) {
    Column(
        modifier = modifier.fillMaxHeight(),
        verticalArrangement = Arrangement.SpaceEvenly,
    ) {
        LzCircle(modifier = Modifier.weight(1f)) {
            Text(avgDay.toString())
        }
        Box(modifier = Modifier.height(8.dp))
        LzCircle(modifier = Modifier.weight(1f)) {
            Text(avgWeek.toString())
        }
        Box(modifier = Modifier.height(4.dp))
    }
}

@Preview(widthDp = 275)
@Composable
private fun LazyStatsSectionPreview() {
    LazyStatsSection()
}

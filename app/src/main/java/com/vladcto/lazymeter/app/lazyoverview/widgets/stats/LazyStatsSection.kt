package com.vladcto.lazymeter.app.lazyoverview.widgets.stats

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vladcto.lazymeter.app.uikit.LzCircle
import com.vladcto.lazymeter.app.uikit.LzLazyReasonCircle
import com.vladcto.lazymeter.app.uikit.LzSection
import com.vladcto.lazymeter.data.lazy.domain.LazyReason

@Composable
fun LazyStatsSection(
    modifier: Modifier = Modifier,
    todayLazy: Int,
    avgDay: Float,
    avgWeek: Float,
    tiredCount: Int,
    distractedCount: Int,
    boringCount: Int,
    hardCount: Int,
) {
    val spacer = @Composable { Spacer(modifier = Modifier.width(4.dp)) }
    return LzSection(
        modifier = modifier,
        title = "Статистика",
    ) {
        Row(
            modifier =
                Modifier
                    .height(150.dp)
                    .fillMaxWidth(),
        ) {
            spacer()
            UnitsPreview(
                modifier = Modifier.weight(3f),
                unitResolver = {
                    when (it) {
                        LazyReason.Tired -> tiredCount
                        LazyReason.Distracted -> distractedCount
                        LazyReason.Boring -> boringCount
                        LazyReason.Hard -> hardCount
                    }
                },
            )
            spacer()
            DayPreview(
                modifier =
                    Modifier
                        .weight(3f)
                        .padding(
                            start = 4.dp,
                            end = 4.dp,
                            bottom = 8.dp,
                        ),
                todayLazy = todayLazy,
                grade = 10f,
            )
            spacer()
            StatPreview(
                modifier =
                    Modifier
                        .weight(3f)
                        .padding(vertical = 4.dp),
                avgDay = avgDay,
                avgWeek = avgWeek,
            )
            spacer()
        }
    }
}

@Composable
private fun UnitsPreview(
    modifier: Modifier = Modifier,
    unitResolver: (LazyReason) -> Int,
) {
    val paddingOffset = 22.dp

    return Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        val columnModifier =
            Modifier
                .weight(1f)
                .fillMaxSize()

        val unitCircle: @Composable ColumnScope.(LazyReason) -> Unit = { reason: LazyReason ->
            UnitCircle(reason, unitResolver(reason))
        }

        Column(
            columnModifier.padding(bottom = paddingOffset),
        ) {
            unitCircle(LazyReason.Tired)
            unitCircle(LazyReason.Hard)
        }
        Column(
            columnModifier.padding(top = paddingOffset),
        ) {
            unitCircle(LazyReason.Distracted)
            unitCircle(LazyReason.Boring)
        }
    }
}

@Composable
fun ColumnScope.UnitCircle(
    reason: LazyReason,
    value: Int,
) {
    LzLazyReasonCircle(
        modifier = Modifier.weight(1f),
        reason = reason,
    ) {
        Text(text = value.toString())
    }
}

@Composable
private fun DayPreview(
    modifier: Modifier = Modifier,
    todayLazy: Int,
    grade: Float,
) {
    return Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        LzCircle {
            Text(text = todayLazy.toString())
            LzCircle(
                modifier =
                    Modifier
                        .align(Alignment.BottomEnd)
                        .offset(0.dp, 8.dp)
                        .fillMaxSize(0.4f),
                color = Color.White,
            ) {
                Text(text = grade.toString())
            }
        }
    }
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

// PREVIEW

@Preview(widthDp = 275, heightDp = 175)
@Composable
private fun LazyStatsSectionPreview() {
    LazyStatsSection(
        todayLazy = 2,
        avgDay = 2.45f,
        avgWeek = 12.45f,
        boringCount = 12,
        distractedCount = 9,
        hardCount = 0,
        tiredCount = 56,
    )
}

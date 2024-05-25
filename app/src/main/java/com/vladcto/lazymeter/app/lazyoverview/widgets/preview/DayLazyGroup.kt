package com.vladcto.lazymeter.app.lazyoverview.widgets.preview

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.vladcto.lazymeter.app.theme.values.unit
import com.vladcto.lazymeter.app.uikit.LzGroup
import com.vladcto.lazymeter.app.uikit.LzLazyUnitsFlowRow
import com.vladcto.lazymeter.data.lazy.domain.LazyReason
import com.vladcto.lazymeter.data.lazy.domain.LazyUnit
import java.time.LocalDateTime

@Composable
fun DayLazyGroup(
    modifier: Modifier = Modifier,
    units: List<LazyUnit>,
) {
    val sortedUnits = units.sortedBy { it.time }
    val unitGroups =
        sortedUnits.groupBy {
            it.time.toLocalDate()
        }

    LazyColumn(modifier = modifier) {
        items(unitGroups.keys.toList()) { date ->
            val groupedUnits = unitGroups[date]

            LzGroup(title = "${date.dayOfMonth} ${date.month.name}") {
                LzLazyUnitsFlowRow(
                    units = groupedUnits,
                    circleTitleSolver = { "${it.time.hour}" },
                    circleSize = 5.unit,
                )
            }
        }
    }
}

// Preview

@Preview(widthDp = 150)
@Composable
private fun MonthLazyGroupsPreview() {
    val repeatUnit =
        LazyUnit(
            reason = LazyReason.Boring,
            time = LocalDateTime.of(2022, 7, 30, 12, 5),
        )
    val units =
        listOf(
            LazyUnit(
                reason = LazyReason.Tired,
                time = LocalDateTime.of(2022, 6, 15, 15, 30),
            ),
            LazyUnit(
                reason = LazyReason.Boring,
                time = LocalDateTime.of(2022, 6, 22, 10, 45),
            ),
            LazyUnit(
                reason = LazyReason.Hard,
                time = LocalDateTime.of(2022, 6, 7, 13, 0),
            ),
            LazyUnit(
                reason = LazyReason.Hard,
                time = LocalDateTime.of(2021, 9, 21, 9, 35),
            ),
            LazyUnit(
                reason = LazyReason.Distracted,
                time = LocalDateTime.of(2023, 2, 18, 14, 50),
            ),
            *List(5) { repeatUnit }.toTypedArray(),
            LazyUnit(
                reason = LazyReason.Hard,
                time = LocalDateTime.of(2021, 10, 14, 10, 20),
            ),
        )
    DayLazyGroup(
        units = units,
    )
}

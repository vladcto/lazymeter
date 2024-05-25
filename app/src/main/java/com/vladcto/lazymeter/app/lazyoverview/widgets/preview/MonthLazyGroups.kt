package com.vladcto.lazymeter.app.lazyoverview.widgets.preview

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.vladcto.lazymeter.app.uikit.LzGroup
import com.vladcto.lazymeter.app.uikit.LzLazyUnitsFlowRow
import com.vladcto.lazymeter.core.theme.unit
import com.vladcto.lazymeter.data.lazy.domain.LazyReason
import com.vladcto.lazymeter.data.lazy.domain.LazyUnit
import java.time.LocalDateTime

@Composable
fun MonthLazyGroups(
    modifier: Modifier = Modifier,
    units: List<LazyUnit>,
) {
    val sortedUnits = units.sortedBy { it.time }
    val unitGroups = sortedUnits.groupBy { it.time.month }

    Column(modifier = modifier) {
        unitGroups.keys.map { date ->
            val groupedUnits = unitGroups[date]
            LzGroup(title = date.name) {
                LzLazyUnitsFlowRow(
                    units = groupedUnits,
                    circleTitleSolver = { "${it.time.dayOfMonth}" },
                    circleSize = 4.unit,
                    circleBorderSize = 0.2.unit,
                )
            }
        }
    }
}

// PREVIEW

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
                reason = LazyReason.Tired,
                time = LocalDateTime.of(2023, 2, 18, 14, 50),
            ),
            *List(5) { repeatUnit }.toTypedArray(),
            LazyUnit(
                reason = LazyReason.Hard,
                time = LocalDateTime.of(2021, 10, 14, 10, 20),
            ),
        )
    MonthLazyGroups(
        units = units,
    )
}

package com.vladcto.lazymeter.app.lazyoverview.viewmodel

import com.vladcto.lazymeter.data.lazy.domain.LazyUnit

data class LazyOverviewPreviewState(
    val units: List<LazyUnit>,
)

// Can be get from LazyOverviewPreviewState but i want practise with Room SQL.

data class LazyOverviewUnitCount(
    val tired: Int,
    val distracted: Int,
    val boring: Int,
    val hard: Int,
)

enum class LazyOverviewDisplayMode {
    Day,
    Month,
}

data class LazyOverviewStatsState(
    val untisCount: LazyOverviewUnitCount,
    val todayCount: Int,
    val todayDiffToMonth: Int,
    val avgDay: Float,
    val avgWeek: Float,
)

package com.vladcto.lazymeter.data.lazy.domain

import java.util.Date

enum class LazyReason {
    tired,
    distracted,
}

data class LazyUnit(
    val time: Date,
    val reason: LazyReason,
)
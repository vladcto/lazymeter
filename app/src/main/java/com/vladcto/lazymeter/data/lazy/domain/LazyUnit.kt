package com.vladcto.lazymeter.data.lazy.domain

import java.util.Date

enum class LazyReason {
    Tired,
    Distracted,
}

data class LazyUnit(
    val time: Date,
    val reason: LazyReason,
)

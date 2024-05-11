package com.vladcto.lazymeter.data.lazy.domain

import java.util.Date

enum class LazyReason {
    Tired,
    Distracted,
    Boring,
    Hard,
}

data class LazyUnit(
    val time: Date,
    val reason: LazyReason,
)

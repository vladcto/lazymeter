package com.vladcto.lazymeter.data.lazy.domain

import java.time.LocalDateTime

enum class LazyReason {
    Tired,
    Distracted,
    Boring,
    Hard,
}

data class LazyUnit(
    val time: LocalDateTime,
    val reason: LazyReason,
)

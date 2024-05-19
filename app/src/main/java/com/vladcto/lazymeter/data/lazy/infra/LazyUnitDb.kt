package com.vladcto.lazymeter.data.lazy.infra

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

enum class LazyReasonDb {
    Tired,
    Distracted,
    Hard,
    Boring,
}

@Entity(tableName = "lazyUnit")
data class LazyUnitDb(
    @PrimaryKey(autoGenerate = true) val uid: Int = 0,
    val reason: LazyReasonDb,
    val time: LocalDateTime,
)

package com.vladcto.lazymeter.data.lazy.infra

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import java.time.LocalDateTime

@Dao
interface LazyUnitDao {
    @Query("SELECT * FROM lazyUnit")
    suspend fun getAll(): List<LazyUnitDb>

    @Query("DELETE FROM lazyUnit")
    suspend fun clear()

    @Insert
    suspend fun insert(unit: LazyUnitDb)

    @Query(
        "SELECT COUNT(*) FROM lazyUnit " +
            "WHERE :startTime <= time " +
            "AND time < :endTime",
    )
    suspend fun getCountInRange(
        startTime: LocalDateTime,
        endTime: LocalDateTime,
    ): Int

    @Query(
        "SELECT COUNT(*) FROM lazyUnit " +
            "WHERE reason == :reason " +
            "AND :startTime <= time " +
            "AND time < :endTime",
    )
    suspend fun getReasonCountInRange(
        reason: LazyReasonDb,
        startTime: LocalDateTime,
        endTime: LocalDateTime,
    ): Int

    @Query(
        "SELECT COUNT(*) FROM LAZYUNIT " +
            "WHERE :startTime <= time AND time < :endTime",
    )
    suspend fun getReasonCountInRange(
        startTime: LocalDateTime,
        endTime: LocalDateTime,
    ): Int
}

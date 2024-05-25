package com.vladcto.lazymeter.data.lazy.repository

import com.vladcto.lazymeter.data.lazy.domain.LazyReason
import com.vladcto.lazymeter.data.lazy.domain.LazyUnit
import com.vladcto.lazymeter.data.lazy.infra.LazyReasonDb
import com.vladcto.lazymeter.data.lazy.infra.LazyUnitDao
import com.vladcto.lazymeter.data.lazy.infra.LazyUnitDb
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import java.time.Duration
import java.time.LocalDate
import javax.inject.Inject

class LazyUnitRepository
    @Inject
    constructor(private val _lazyUnitDao: LazyUnitDao) {
        suspend fun getAll(): List<LazyUnit> =
            withContext(Dispatchers.IO) {
                val result =
                    async {
                        _lazyUnitDao.getAll()
                    }.await()
                return@withContext result.map { it.toDb() }
            }

        suspend fun add(unit: LazyUnit) =
            withContext(Dispatchers.IO) {
                _lazyUnitDao.insert(unit.toDb())
            }

        suspend fun getCountInDay(date: LocalDate): Int {
            val startTime = date.atStartOfDay()
            val endTime = startTime.plusHours(24)
            return _lazyUnitDao.getCountInRange(
                startTime = startTime,
                endTime = endTime,
            )
        }

        suspend fun getCountInDay(
            reason: LazyReason,
            date: LocalDate,
        ): Int {
            val startTime = date.atStartOfDay()
            val endTime = startTime.plusHours(24)
            return _lazyUnitDao.getCountInRange(
                reason = reason.toDb(),
                startTime = startTime,
                endTime = endTime,
            )
        }

        suspend fun avgDayCount(date: LocalDate): Float {
            val startTime = date.atStartOfDay().minusDays(6)
            val endTime = date.atStartOfDay().plusDays(1)
            val count = _lazyUnitDao.getCountInRange(startTime, endTime)
            return count / (Duration.between(startTime, endTime).toDays().toFloat())
        }
    }

// Mappers

private fun LazyUnit.toDb(): LazyUnitDb =
    LazyUnitDb(
        time = this.time,
        reason = reason.toDb(),
    )

private fun LazyReason.toDb(): LazyReasonDb =
    when (this) {
        LazyReason.Tired -> LazyReasonDb.Tired
        LazyReason.Boring -> LazyReasonDb.Boring
        LazyReason.Distracted -> LazyReasonDb.Distracted
        LazyReason.Hard -> LazyReasonDb.Hard
    }

private fun LazyUnitDb.toDb(): LazyUnit =
    LazyUnit(
        time = this.time,
        reason =
            when (this.reason) {
                LazyReasonDb.Tired -> LazyReason.Tired
                LazyReasonDb.Boring -> LazyReason.Boring
                LazyReasonDb.Distracted -> LazyReason.Distracted
                LazyReasonDb.Hard -> LazyReason.Hard
            },
    )

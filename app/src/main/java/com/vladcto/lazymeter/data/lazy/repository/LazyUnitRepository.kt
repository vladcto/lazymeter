package com.vladcto.lazymeter.data.lazy.repository

import com.vladcto.lazymeter.data.lazy.domain.LazyReason
import com.vladcto.lazymeter.data.lazy.domain.LazyUnit
import com.vladcto.lazymeter.data.lazy.infra.LazyReasonDb
import com.vladcto.lazymeter.data.lazy.infra.LazyUnitDao
import com.vladcto.lazymeter.data.lazy.infra.LazyUnitDb
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
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
                return@withContext result.map { it.toDomain() }
            }

        suspend fun clear() =
            withContext(Dispatchers.IO) {
                return@withContext _lazyUnitDao.clear()
            }

        suspend fun add(unit: LazyUnit) =
            withContext(Dispatchers.IO) {
                _lazyUnitDao.insert(unit.toDb())
            }
    }

// Mappers

private fun LazyUnit.toDb(): LazyUnitDb =
    LazyUnitDb(
        time = this.time,
        reason = LazyReasonDb.valueOf(this.reason.name),
    )

private fun LazyUnitDb.toDomain(): LazyUnit =
    LazyUnit(
        time = this.time,
        reason = LazyReason.valueOf(this.reason.name),
    )

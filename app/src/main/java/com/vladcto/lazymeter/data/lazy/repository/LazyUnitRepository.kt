package com.vladcto.lazymeter.data.lazy.repository

import com.vladcto.lazymeter.data.lazy.domain.LazyUnit
import com.vladcto.lazymeter.data.lazy.infra.LazyUnitDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext

class LazyUnitRepository(private val lazyUnitDao: LazyUnitDao) {
    suspend fun getAll(): List<LazyUnit> = withContext(Dispatchers.IO) {
        val result = async {
            lazyUnitDao.getAll()
        }.await()
        return@withContext result.map { it.toDomain() }
    }

    suspend fun add(unit: LazyUnit) = withContext(Dispatchers.IO) {
        return@withContext addAll(listOf(unit))
    }

    suspend fun addAll(units: List<LazyUnit>) = withContext(Dispatchers.IO) {
        return@withContext lazyUnitDao.insertAll(units.map { it.toDb() })
    }
}
package com.vladcto.lazymeter.data.lazy.infra

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface LazyUnitDao {
    @Query("SELECT * FROM lazyUnit")
    suspend fun getAll(): List<LazyUnitDb>

    @Insert
    suspend fun insertAll(units: List<LazyUnitDb>)
}
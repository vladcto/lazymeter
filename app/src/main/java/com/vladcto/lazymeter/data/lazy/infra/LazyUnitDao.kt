package com.vladcto.lazymeter.data.lazy.infra

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface LazyUnitDao {
    @Query("SELECT * FROM lazyUnit")
    suspend fun getAll(): List<LazyUnitDb>

    @Query("DELETE FROM lazyUnit")
    suspend fun clear()

    @Insert
    suspend fun insert(unit: LazyUnitDb)
}

package com.vladcto.lazymeter.core.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.vladcto.lazymeter.core.room.converter.RoomDateLongConverter
import com.vladcto.lazymeter.data.lazy.infra.LazyUnitDao
import com.vladcto.lazymeter.data.lazy.infra.LazyUnitDb

@Database(
    entities = [LazyUnitDb::class],
    version = 1,
)
@TypeConverters(RoomDateLongConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun lazyUnitDao(): LazyUnitDao
}

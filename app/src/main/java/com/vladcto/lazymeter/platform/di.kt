package com.vladcto.lazymeter.platform

import androidx.room.Room
import com.vladcto.lazymeter.platform.room.AppDatabase

val db = Room.databaseBuilder(
    context = throw Exception(),
    AppDatabase::class.java,
    "lazy-database"
).build()
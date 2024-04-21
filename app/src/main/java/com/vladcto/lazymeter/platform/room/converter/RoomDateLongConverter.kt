package com.vladcto.lazymeter.platform.room.converter

import androidx.room.TypeConverter
import java.util.Date

class RoomDateLongConverter {
    @TypeConverter
    fun dateToLong(date: Date?): Long? = date?.time

    @TypeConverter
    fun longToDate(value: Long?): Date? = value?.let { Date(it) }
}
package com.vladcto.lazymeter.core.room.converter

import androidx.room.TypeConverter
import java.time.LocalDateTime
import java.time.ZoneOffset

class RoomDateLongConverter {
    @TypeConverter
    fun dateToLong(date: LocalDateTime?): Long? = date?.toEpochSecond(ZoneOffset.UTC)

    @TypeConverter
    fun longToDate(value: Long?): LocalDateTime? =
        value?.let {
            LocalDateTime.ofEpochSecond(
                it,
                0,
                ZoneOffset.UTC,
            )
        }
}

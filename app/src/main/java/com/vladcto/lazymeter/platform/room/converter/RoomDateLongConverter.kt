package com.vladcto.lazymeter.platform.room.converter

import androidx.room.ProvidedTypeConverter
import java.util.Date

@ProvidedTypeConverter
class RoomDateLongConverter {
    fun dateToLong(date: Date?): Long? = date?.time

    fun longToDate(value: Long?): Date? = value?.let { Date(it) }
}
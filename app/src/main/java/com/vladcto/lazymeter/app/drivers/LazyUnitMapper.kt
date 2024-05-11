package com.vladcto.lazymeter.app.drivers

import com.vladcto.lazymeter.data.lazy.domain.LazyReason
import com.vladcto.lazymeter.data.lazy.domain.LazyUnit
import java.text.SimpleDateFormat
import java.util.Locale

fun LazyReason.translatedName() =
    when (this) {
        LazyReason.Distracted -> "Отвелкся"
        LazyReason.Tired -> "Устал"
        LazyReason.Hard -> "Сложно"
        LazyReason.Boring -> "Скучно"
    }

fun LazyUnit.formattedDate(locale: Locale): String {
    val dateFormat = SimpleDateFormat("HH:mm dd-MM-yy", locale)
    return dateFormat.format(time)
}

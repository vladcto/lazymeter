package com.vladcto.lazymeter.app.drivers

import com.vladcto.lazymeter.data.lazy.domain.LazyReason

fun LazyReason.translatedName() =
    when (this) {
        LazyReason.Distracted -> "Отвелкся"
        LazyReason.Tired -> "Устал"
        LazyReason.Hard -> "Сложно"
        LazyReason.Boring -> "Скучно"
    }

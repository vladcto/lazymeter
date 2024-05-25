package com.vladcto.lazymeter.app.theme.values

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

val Int.unit: Dp
    get() = (this * 8).dp

val Float.unit: Dp
    get() = (this * 8).dp

val Double.unit: Dp
    get() = (this * 8).dp

package com.vladcto.lazymeter.app.theme.extensions

import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val ColorScheme.tiredColor: Color
    @Composable get() = Color(0xFFA8FF10)

val ColorScheme.distractedColor: Color
    @Composable get() = Color(0xFF0F58FF)

val ColorScheme.boringColor: Color
    @Composable get() = Color(0xFF475880)

val ColorScheme.hardColor: Color
    @Composable get() = Color(0xFFFF390F)

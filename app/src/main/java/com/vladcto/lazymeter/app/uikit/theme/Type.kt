package com.vladcto.lazymeter.app.uikit.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

const val FONT_SIZE = 16
const val LINE_HEIGHT = 22
const val LETTER_SPACING = 0.4

val boldTextStyle =
    TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold,
        fontSize = (FONT_SIZE + 2).sp,
        lineHeight = LINE_HEIGHT.sp,
        letterSpacing = LETTER_SPACING.sp,
    )

val mediumTextStyle =
    TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = FONT_SIZE.sp,
        lineHeight = LINE_HEIGHT.sp,
        letterSpacing = LETTER_SPACING.sp,
    )

val lightTextStyle =
    TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Light,
        fontSize = (FONT_SIZE - 2).sp,
        lineHeight = LINE_HEIGHT.sp,
        letterSpacing = LETTER_SPACING.sp,
    )

package com.vladcto.lazymeter.app.uikit

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.TextUnit
import com.vladcto.lazymeter.app.theme.values.boldTextStyle
import com.vladcto.lazymeter.app.theme.values.mediumTextStyle

class LzText {
    companion object {
        @Composable
        fun bold(
            text: String,
            fontSize: TextUnit = TextUnit.Unspecified,
        ) {
            Text(text, style = boldTextStyle, fontSize = fontSize)
        }

        @Composable
        fun medium(
            text: String,
            fontSize: TextUnit = TextUnit.Unspecified,
        ) {
            Text(text, style = mediumTextStyle, fontSize = fontSize)
        }
    }
}

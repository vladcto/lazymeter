package com.vladcto.lazymeter.app.uikit

import androidx.compose.foundation.clickable
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.TextUnit
import com.vladcto.lazymeter.core.theme.boldTextStyle
import com.vladcto.lazymeter.core.theme.lightTextStyle
import com.vladcto.lazymeter.core.theme.linkHighlight
import com.vladcto.lazymeter.core.theme.mediumTextStyle

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
            textAlign: TextAlign? = null,
        ) {
            Text(
                text,
                style = mediumTextStyle,
                textAlign = textAlign,
                fontSize = fontSize,
            )
        }

        @Composable
        fun light(
            modifier: Modifier = Modifier,
            text: String,
            fontSize: TextUnit = TextUnit.Unspecified,
            textAlign: TextAlign? = null,
        ) {
            Text(
                modifier = modifier,
                text = text,
                style = lightTextStyle,
                textAlign = textAlign,
                fontSize = fontSize,
            )
        }

        @Composable
        fun clickable(
            text: String,
            onTap: () -> Unit,
            fontSize: TextUnit = TextUnit.Unspecified,
            textAlign: TextAlign? = null,
        ) {
            Text(
                modifier = Modifier.clickable(onClick = { onTap() }),
                text = text,
                textAlign = textAlign,
                fontSize = fontSize,
                color = MaterialTheme.colorScheme.linkHighlight,
                fontWeight = FontWeight.SemiBold,
                style =
                    mediumTextStyle.copy(
                        textDecoration = TextDecoration.Underline,
                    ),
            )
        }
    }
}

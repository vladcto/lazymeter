package com.vladcto.lazymeter.feature.preview_lazy.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.vladcto.lazymeter.data.lazy.domain.LazyUnit

@Composable
fun CreateLazyUnitDialog(onComplete: (LazyUnit) -> Unit) {
    AlertDialog(
        icon = {
            Icon(
                Icons.Rounded.Edit,
                contentDescription = ""
            )
        },
        title = {
            Text(text = "Почему вы пинали балду?")
        },
        onDismissRequest = {},
        confirmButton = {
            TextButton(onClick = {}) {

            }
        },
    )
}

@Preview
@Composable
fun CreateLazyUnitDialogPreview() {
    CreateLazyUnitDialog(onComplete = {})
}

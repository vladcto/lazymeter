package com.vladcto.lazymeter.app.lazy_overview.preview.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.vladcto.lazymeter.data.lazy.domain.LazyReason
import com.vladcto.lazymeter.data.lazy.domain.LazyUnit
import java.util.Date

@Composable
fun CreateLazyUnitDialog(onDismissRequest: () -> Unit, onComplete: (LazyUnit) -> Unit) {
    val choiceTired = remember { mutableStateOf(true) }
    AlertDialog(
        onDismissRequest = onDismissRequest,
        icon = {
            Icon(
                Icons.Rounded.Edit,
                contentDescription = ""
            )
        },
        title = {
            Text(text = "Почему вы пинали балду?")
        },
        text = {
            Column(modifier = Modifier.selectableGroup()) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = choiceTired.value,
                        onClick = { choiceTired.value = true })
                    Text(text = "Устал", modifier = Modifier.padding(start = 16.dp))

                }
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = !choiceTired.value,
                        onClick = { choiceTired.value = false })
                    Text(text = "Отвлекся", modifier = Modifier.padding(start = 16.dp))
                }
            }
        },
        confirmButton = {
            TextButton(
                onClick = {
                    onComplete(
                        LazyUnit(
                            time = Date(),
                            reason = LazyReason.Tired.takeIf { choiceTired.value }
                                ?: LazyReason.Distracted
                        )
                    )
                    onDismissRequest()
                }
            ) {
                Text(text = "Подтвердить")
            }
        },
    )
}
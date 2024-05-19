package com.vladcto.lazymeter.app.uikit

import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.vladcto.lazymeter.data.lazy.domain.LazyUnit

@Composable
fun LzLazyUnitsFlowRow(
    modifier: Modifier = Modifier,
    units: List<LazyUnit>?,
    circleTitleSolver: (LazyUnit) -> String,
) {
    FlowRow(modifier = modifier) {
        units?.map {
            LzLazyReasonCircle(
                modifier = Modifier.size(32.dp),
                reason = it.reason,
            ) {
                Text(text = circleTitleSolver(it))
            }
        }
    }
}

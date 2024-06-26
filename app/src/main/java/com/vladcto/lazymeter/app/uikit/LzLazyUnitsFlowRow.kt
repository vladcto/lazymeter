package com.vladcto.lazymeter.app.uikit

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import com.vladcto.lazymeter.data.lazy.domain.LazyUnit

@Composable
fun LzLazyUnitsFlowRow(
    modifier: Modifier = Modifier,
    units: List<LazyUnit>?,
    circleTitleSolver: (LazyUnit) -> String,
    circleSize: Dp,
    circleBorderSize: Dp? = null,
) {
    FlowRow(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
    ) {
        units?.map {
            Box(modifier = Modifier.padding(circleSize / 4)) {
                LzLazyReasonCircle(
                    modifier = Modifier.size(circleSize),
                    reason = it.reason,
                    borderSize = circleBorderSize,
                ) {
                    Text(text = circleTitleSolver(it))
                }
            }
        }
    }
}

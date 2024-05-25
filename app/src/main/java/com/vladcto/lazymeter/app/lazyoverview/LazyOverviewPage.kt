package com.vladcto.lazymeter.app.lazyoverview

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.vladcto.lazymeter.app.lazyoverview.viewmodel.LazyOverviewDisplayMode
import com.vladcto.lazymeter.app.lazyoverview.viewmodel.PreviewLazyViewModel
import com.vladcto.lazymeter.app.lazyoverview.widgets.preview.LazyPreviewSection
import com.vladcto.lazymeter.app.lazyoverview.widgets.stats.LazyStatsSection
import com.vladcto.lazymeter.app.uikit.LzText
import com.vladcto.lazymeter.core.theme.Paddings
import com.vladcto.lazymeter.core.theme.boringColor
import com.vladcto.lazymeter.core.theme.distractedColor
import com.vladcto.lazymeter.core.theme.hardColor
import com.vladcto.lazymeter.core.theme.mainBackground
import com.vladcto.lazymeter.core.theme.tiredColor
import com.vladcto.lazymeter.core.theme.unit
import com.vladcto.lazymeter.data.lazy.domain.LazyReason

@Composable
fun LazyPreviewPage(overviewLazyViewModel: PreviewLazyViewModel = viewModel()) {
    val lazyOverviewState by overviewLazyViewModel.overviewState.collectAsState()
    val statsState by overviewLazyViewModel.statsState.collectAsState()
    val unitsCount = statsState.untisCount
    val displayMode by overviewLazyViewModel.displayModeState.collectAsState()

    Scaffold(topBar = {
        TopAppBar(
            colors =
                TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.mainBackground,
                ),
            title = {
                Text(
                    "LazyMeter",
                    fontSize = 20.sp,
                )
            },
        )
    }, bottomBar = {
        Row(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.mainBackground)
                    .padding(
                        start = Paddings.small,
                        top = Paddings.medium,
                        bottom = Paddings.large * 2,
                        end = Paddings.small,
                    ),
            horizontalArrangement = Arrangement.SpaceEvenly,
        ) {
            LazyReasonClickButton(
                reason = LazyReason.Tired,
                onTap = { overviewLazyViewModel.addLazyUnit(LazyReason.Tired) },
            )
            LazyReasonClickButton(
                reason = LazyReason.Distracted,
                onTap = { overviewLazyViewModel.addLazyUnit(LazyReason.Distracted) },
            )
            LazyReasonClickButton(
                reason = LazyReason.Boring,
                onTap = { overviewLazyViewModel.addLazyUnit(LazyReason.Boring) },
            )
            LazyReasonClickButton(
                reason = LazyReason.Hard,
                onTap = { overviewLazyViewModel.addLazyUnit(LazyReason.Hard) },
            )
        }
    }) {
        Column(
            modifier =
                Modifier
                    .padding(it)
                    .padding(horizontal = 4.dp)
                    .verticalScroll(rememberScrollState())
                    .fillMaxHeight(),
        ) {
            Spacer(modifier = Modifier.height(Paddings.large))
            LazyStatsSection(
                todayLazy = statsState.todayCount,
                avgDay = statsState.avgDay,
                avgWeek = statsState.avgWeek,
                boringCount = unitsCount.boring,
                tiredCount = unitsCount.tired,
                distractedCount = unitsCount.distracted,
                hardCount = unitsCount.hard,
            )
            LazyPreviewSection(
                lazyUnits = lazyOverviewState.units,
                displayMonth = displayMode == LazyOverviewDisplayMode.Month,
                actions = {
                    val title =
                        when (displayMode) {
                            LazyOverviewDisplayMode.Day -> "День"
                            LazyOverviewDisplayMode.Month -> "Месяц"
                        }
                    LzText.clickable(
                        text = title,
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center,
                        onTap = {
                            overviewLazyViewModel.changeDisplayMode()
                        },
                    )
                },
            )
        }
    }
}

@Composable
private fun RowScope.LazyReasonClickButton(
    reason: LazyReason,
    onTap: () -> Unit,
) {
    val colorScheme = MaterialTheme.colorScheme
    val titleAndColor =
        when (reason) {
            LazyReason.Tired -> Pair("Cкучно", colorScheme.tiredColor)
            LazyReason.Boring -> Pair("Устал", colorScheme.boringColor)
            LazyReason.Distracted -> Pair("Отвелкся", colorScheme.distractedColor)
            LazyReason.Hard -> Pair("Сложно", colorScheme.hardColor)
        }

    val circle = @Composable {
        Box(
            modifier =
                Modifier
                    .size(5.unit)
                    .aspectRatio(1f)
                    .clip(CircleShape)
                    .clickable(onClick = onTap)
                    .background(Color.Black, CircleShape)
                    .padding(0.2.unit)
                    .background(titleAndColor.second, CircleShape),
            contentAlignment = Alignment.Center,
        ) {}
    }
    val title = @Composable {
        LzText.medium(text = titleAndColor.first, textAlign = TextAlign.Center)
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        circle()
        title()
    }
}

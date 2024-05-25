package com.vladcto.lazymeter.app.lazyoverview.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vladcto.lazymeter.data.lazy.domain.LazyReason
import com.vladcto.lazymeter.data.lazy.domain.LazyUnit
import com.vladcto.lazymeter.data.lazy.repository.LazyUnitRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.LocalDateTime
import javax.inject.Inject

@HiltViewModel
class PreviewLazyViewModel
    @Inject
    constructor(private val _lazyUnitRepository: LazyUnitRepository) : ViewModel() {
        private val _overviewState =
            MutableStateFlow(
                LazyOverviewPreviewState(listOf()),
            )
        private val _statsState =
            MutableStateFlow(
                LazyOverviewStatsState(
                    avgDay = 0f,
                    avgWeek = 0f,
                    untisCount =
                        LazyOverviewUnitCount(
                            boring = 0,
                            distracted = 0,
                            hard = 0,
                            tired = 0,
                        ),
                    todayCount = 0,
                    todayDiffToMonth = 0,
                ),
            )

        val overviewState = _overviewState.asStateFlow()
        val statsState = _statsState.asStateFlow()

        init {
            viewModelScope.launch { updateState() }
        }

        fun addLazyUnit(reason: LazyReason) {
            val unit = LazyUnit(LocalDateTime.now(), reason)
            viewModelScope.launch {
                _lazyUnitRepository.add(unit)
                updateState()
                _overviewState.update { currentState ->
                    LazyOverviewPreviewState(currentState.units + unit)
                }
            }
        }

        private suspend fun updateState() {
            val units = _lazyUnitRepository.getAll()
            _overviewState.update { _ ->
                LazyOverviewPreviewState(units)
            }
            val nowDate = LocalDate.now()
            val tiredCount = _lazyUnitRepository.getCountInDay(LazyReason.Tired, nowDate)
            val distractedCount = _lazyUnitRepository.getCountInDay(LazyReason.Distracted, nowDate)
            val boringCount = _lazyUnitRepository.getCountInDay(LazyReason.Boring, nowDate)
            val hardCount = _lazyUnitRepository.getCountInDay(LazyReason.Hard, nowDate)
            _statsState.update { _ ->
                LazyOverviewStatsState(
                    todayCount = _lazyUnitRepository.getCountInDay(nowDate),
                    todayDiffToMonth = 0,
                    avgDay = _lazyUnitRepository.avgDayCount(nowDate),
                    avgWeek = _lazyUnitRepository.avgDayCount(nowDate),
                    untisCount =
                        LazyOverviewUnitCount(
                            tired = tiredCount,
                            distracted = distractedCount,
                            boring = boringCount,
                            hard = hardCount,
                        ),
                )
            }
        }
    }

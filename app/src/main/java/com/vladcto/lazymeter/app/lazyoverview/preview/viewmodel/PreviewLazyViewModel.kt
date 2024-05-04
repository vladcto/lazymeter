package com.vladcto.lazymeter.app.lazyoverview.preview.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vladcto.lazymeter.data.lazy.domain.LazyUnit
import com.vladcto.lazymeter.data.lazy.repository.LazyUnitRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class PreviewLazyState(
    val lazyUnits: List<LazyUnit>,
)

@HiltViewModel
class PreviewLazyViewModel
    @Inject
    constructor(
        private val _lazyUnitRepository: LazyUnitRepository,
    ) : ViewModel() {
        init {
            viewModelScope.launch {
                val result = _lazyUnitRepository.getAll()
                _previewState.update { _ -> PreviewLazyState(result) }
            }
        }

        private val _previewState = MutableStateFlow(PreviewLazyState(listOf()))
        val previewState = _previewState.asStateFlow()

        fun addLazyUnit(unit: LazyUnit) {
            viewModelScope.launch {
                _lazyUnitRepository.add(unit)
                _previewState.update { currentState ->
                    PreviewLazyState(currentState.lazyUnits + unit)
                }
            }
        }

        fun clear() =
            viewModelScope.launch {
                _lazyUnitRepository.clear()
                _previewState.update { _ -> PreviewLazyState(listOf()) }
            }
    }

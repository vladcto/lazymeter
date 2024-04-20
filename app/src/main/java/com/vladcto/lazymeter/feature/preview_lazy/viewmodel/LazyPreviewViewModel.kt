package com.vladcto.lazymeter.feature.preview_lazy.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vladcto.lazymeter.data.lazy.domain.LazyUnit
import com.vladcto.lazymeter.data.lazy.repository.LazyUnitRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class LazyPreviewState(
    val lazyUnits: List<LazyUnit>,
)

class LazyPreviewViewModel @Inject constructor(
    private val _lazyUnitRepository: LazyUnitRepository,
) : ViewModel() {

    init {
        viewModelScope.launch {
            val result = async {
                _lazyUnitRepository.getAll()
            }.await()
            _previewState.update { _ -> LazyPreviewState(result) }
        }
    }

    private val _previewState = MutableStateFlow(
        LazyPreviewState(listOf())
    )
    val previewState = _previewState.asStateFlow()

    fun addLazyUnit(unit: LazyUnit) {
        viewModelScope.launch {
            async { _lazyUnitRepository.add(unit) }.await()
            _previewState.update { currentState ->
                LazyPreviewState(currentState.lazyUnits + unit)
            }
        }
    }

}
package com.vladcto.lazymeter.feature.preview_lazy.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vladcto.lazymeter.data.lazy.domain.LazyUnit
import com.vladcto.lazymeter.data.lazy.repository.LazyUnitRepository
import com.vladcto.lazymeter.feature.another_api_send_using_retrofit.PipeDreamRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class PreviewLazyState(
    val lazyUnits: List<LazyUnit>,
)

@HiltViewModel
class PreviewLazyViewModel @Inject constructor(
    private val _lazyUnitRepository: LazyUnitRepository,
) : ViewModel() {

    init {
        viewModelScope.launch {
            val result = async {
                _lazyUnitRepository.getAll()
            }.await()
            _previewState.update { _ -> PreviewLazyState(result) }
        }
    }

    private val _previewState = MutableStateFlow(
        PreviewLazyState(listOf())
    )
    val previewState = _previewState.asStateFlow()

    fun addLazyUnit(unit: LazyUnit) {
        viewModelScope.launch {
            async { _lazyUnitRepository.add(unit) }.await()
            _previewState.update { currentState ->
                PreviewLazyState(currentState.lazyUnits + unit)
            }
        }
    }

    fun sendLazyUnit(unit: LazyUnit) {
        viewModelScope.launch(context = Dispatchers.IO) {
            PipeDreamRepository.sendLazyUnit(unit)
        }
    }

    fun clear() = viewModelScope.launch {
        _lazyUnitRepository.clear()
        _previewState.update { _ -> PreviewLazyState(listOf()) }
    }

}
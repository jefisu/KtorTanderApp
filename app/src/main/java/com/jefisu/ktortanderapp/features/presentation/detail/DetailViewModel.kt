package com.jefisu.ktortanderapp.features.presentation.detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jefisu.ktortanderapp.features.domain.use_cases.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val useCases: UseCases
) : ViewModel() {

    private val _state = mutableStateOf(DetailState())
    val state: State<DetailState> = _state

    fun onEvent(event: DetailEvent) {
        when (event) {
            is DetailEvent.GetMemberById -> {
                viewModelScope.launch {
                    _state.value = state.value.copy(
                        member = useCases.getMemberById(event.id)
                    )
                }
            }
        }
    }
}
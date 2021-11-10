package com.jefisu.ktortanderapp.features.presentation.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jefisu.ktortanderapp.features.domain.use_cases.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val useCases: UseCases
) : ViewModel() {

    private val _state = mutableStateOf(HomeState())
    val state: State<HomeState> = _state

    init {
        onEvent(HomeEvent.GetAllMembers)
    }

    fun onEvent(event: HomeEvent) {
        when (event) {
            is HomeEvent.GetAllMembers -> {
                viewModelScope.launch {
                    _state.value = state.value.copy(
                        members = useCases.getMembers(),
                        isLoading = false,
                        count = useCases.getMembers().size
                    )
                }
            }
        }
    }
}
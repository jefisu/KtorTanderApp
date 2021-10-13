package com.jefisu.ktortanderapp.features.presentation.detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jefisu.ktortanderapp.features.domain.model.Member
import com.jefisu.ktortanderapp.features.domain.use_cases.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val useCases: UseCases
) : ViewModel() {

    private val _state = mutableStateOf(Member(null, "", "", "", ""))
    val state: State<Member> = _state

    fun getMember(id: Int) {
        viewModelScope.launch {
            _state.value = useCases.getMemberById(id)!!
        }
    }
}
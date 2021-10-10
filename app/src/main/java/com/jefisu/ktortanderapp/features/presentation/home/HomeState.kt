package com.jefisu.ktortanderapp.features.presentation.home

import com.jefisu.ktortanderapp.features.data.model.MemberResponse

data class HomeState(
    val members: List<MemberResponse> = emptyList(),
    val isLoading: Boolean = true
)
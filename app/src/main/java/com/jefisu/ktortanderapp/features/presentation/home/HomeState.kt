package com.jefisu.ktortanderapp.features.presentation.home

import com.jefisu.ktortanderapp.features.domain.model.Member

data class HomeState(
    val members: List<Member> = emptyList(),
    val isLoading: Boolean = true,
    val count: Int = 0
)
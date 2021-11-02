package com.jefisu.ktortanderapp.features.presentation.detail

sealed class DetailEvent {
    data class GetMemberById(val id: Int) : DetailEvent()
}

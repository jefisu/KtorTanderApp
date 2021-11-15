package com.jefisu.ktortanderapp.features.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Member(
    val id: Int?,
    val name: String,
    val nickname: String,
    val imageUrl: String,
    val description: String,
    val messages: List<String>
)

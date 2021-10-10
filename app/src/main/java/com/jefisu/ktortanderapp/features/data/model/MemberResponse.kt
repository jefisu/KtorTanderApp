package com.jefisu.ktortanderapp.features.data.model

import kotlinx.serialization.Serializable

@Serializable
data class MemberResponse(
    val id: Int?,
    val name: String = "",
    val nickname: String = "",
    val imageUrl: String = "",
    val description: String = ""
)

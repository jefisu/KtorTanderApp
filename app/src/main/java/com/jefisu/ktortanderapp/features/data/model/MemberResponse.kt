package com.jefisu.ktortanderapp.features.data.model

import com.jefisu.ktortanderapp.features.domain.model.Member
import kotlinx.serialization.Serializable

@Serializable
data class MemberResponse(
    val id: Int?,
    val name: String,
    val nickname: String,
    val imageUrl: String,
    val description: String,
    val messages: List<String>
) {
    fun toMember(): Member {
        return Member(
            id = id,
            name = name,
            nickname = nickname,
            imageUrl = imageUrl,
            description = description,
            messages = messages
        )
    }
}

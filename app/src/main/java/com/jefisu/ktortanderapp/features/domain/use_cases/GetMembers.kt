package com.jefisu.ktortanderapp.features.domain.use_cases

import com.jefisu.ktortanderapp.features.data.service.TanderService
import com.jefisu.ktortanderapp.features.domain.model.Member

class GetMembers(
    private val service: TanderService
) {
    suspend operator fun invoke(): List<Member> {
        return service.getMember().map { it.toMember() }
    }
}
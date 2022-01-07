package com.jefisu.ktortanderapp.features.domain.use_cases

import com.jefisu.ktortanderapp.features.domain.repository.TanderRepository
import com.jefisu.ktortanderapp.features.domain.model.Member

class GetMembers(
    private val repository: TanderRepository
) {
    suspend operator fun invoke(): List<Member> {
        return repository.getMember().map { it.toMember() }
    }
}
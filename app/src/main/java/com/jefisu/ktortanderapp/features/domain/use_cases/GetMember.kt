package com.jefisu.ktortanderapp.features.domain.use_cases

import com.jefisu.ktortanderapp.features.domain.repository.TanderRepository
import com.jefisu.ktortanderapp.features.domain.model.Member

class GetMember(
    private val repository: TanderRepository
) {
    suspend operator fun invoke(id: Int): Member? {
        return repository.getMemberById(id)?.toMember()
    }
}
package com.jefisu.ktortanderapp.features.domain.use_cases

import com.jefisu.ktortanderapp.features.data.service.TanderService
import com.jefisu.ktortanderapp.features.domain.model.Member

class GetMember(
    private val service: TanderService
) {
    suspend operator fun invoke(id: Int): Member? {
        return service.getMemberById(id)?.toMember()
    }
}
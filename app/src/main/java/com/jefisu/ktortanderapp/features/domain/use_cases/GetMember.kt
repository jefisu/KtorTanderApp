package com.jefisu.ktortanderapp.features.domain.use_cases

import com.jefisu.ktortanderapp.features.data.model.MemberResponse
import com.jefisu.ktortanderapp.features.data.service.TanderService

class GetMember(
    private val service: TanderService
) {
    suspend operator fun invoke(id: Int) : MemberResponse {
        return service.getMemberById(id)
    }
}
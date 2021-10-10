package com.jefisu.ktortanderapp.features.domain.use_cases

import com.jefisu.ktortanderapp.features.data.model.MemberResponse
import com.jefisu.ktortanderapp.features.data.service.TanderService

class GetMembers(
    private val service: TanderService
) {
    suspend operator fun invoke() : List<MemberResponse> {
        return service.getMember()
    }
}
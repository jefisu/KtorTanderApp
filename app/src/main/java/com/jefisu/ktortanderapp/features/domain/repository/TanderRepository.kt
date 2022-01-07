package com.jefisu.ktortanderapp.features.domain.repository

import com.jefisu.ktortanderapp.features.data.model.MemberResponse

interface TanderRepository {

    suspend fun getMember(): List<MemberResponse>
    suspend fun getMemberById(id: Int?): MemberResponse?
}
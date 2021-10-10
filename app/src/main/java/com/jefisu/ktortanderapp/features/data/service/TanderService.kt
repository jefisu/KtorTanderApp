package com.jefisu.ktortanderapp.features.data.service

import com.jefisu.ktortanderapp.features.data.model.MemberResponse

interface TanderService {

    suspend fun getMember() : List<MemberResponse>
    suspend fun getMemberById(id: Int?) : MemberResponse
}
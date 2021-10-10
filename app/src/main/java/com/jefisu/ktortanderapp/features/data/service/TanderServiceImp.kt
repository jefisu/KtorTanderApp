package com.jefisu.ktortanderapp.features.data.service

import com.jefisu.ktortanderapp.features.data.TanderConstants
import com.jefisu.ktortanderapp.features.data.model.MemberResponse
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.request.*

class TanderServiceImp(
    private val client: HttpClient
) : TanderService {

    override suspend fun getMember(): List<MemberResponse> {
        return try {
            client.get {
                url(TanderConstants.MEMBERS)
            }
        } catch (e: RedirectResponseException) {
            // 3xx
            println("Error: ${e.response.status.description}")
            emptyList()
        }
        catch (e: ClientRequestException) {
            // 4xx
            println("Error: ${e.response.status.description}")
            emptyList()
        }
        catch (e: ServerResponseException) {
            // 5xx
            println("Error: ${e.response.status.description}")
            emptyList()
        }
    }

    override suspend fun getMemberById(id: Int?): MemberResponse {
        return try {
            client.get {
                url("${TanderConstants.MEMBERS}/$id")
            }
        } catch (e: RedirectResponseException) {
            // 3xx
            println("Error: ${e.response.status.description}")
            MemberResponse(0, "", "", "", "")
        }
        catch (e: ClientRequestException) {
            // 4xx
            println("Error: ${e.response.status.description}")
            MemberResponse(0, "", "", "", "")

        }
        catch (e: ServerResponseException) {
            // 5xx
            println("Error: ${e.response.status.description}")
            MemberResponse(0, "", "", "", "")
        }
    }
}
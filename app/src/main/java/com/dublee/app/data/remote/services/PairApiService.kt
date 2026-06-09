package com.dublee.app.data.remote.services

import com.dublee.app.data.remote.dto.CreatePairResponse
import com.dublee.app.data.remote.dto.GetCodeResponse
import com.dublee.app.data.remote.dto.JoinPairRequest
import com.dublee.app.data.remote.dto.JoinPairResponse
import com.dublee.app.data.remote.dto.LeavePairResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.bearerAuth
import io.ktor.client.request.delete
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json


class PairApiService {
    val baseUrl = "http://192.168.1.181:8080/api/pairs/"

    private val client = HttpClient {
        install(ContentNegotiation) { json(Json { ignoreUnknownKeys = true }) }
    }

    suspend fun joinPair(token: String, request: JoinPairRequest): JoinPairResponse =
        client.post(baseUrl + "join") {
            contentType(ContentType.Application.Json)
            setBody(request)
            bearerAuth(token)
        }.body()

    suspend fun leavePair(token: String): LeavePairResponse =
        client.delete(baseUrl + "leave") {
            bearerAuth(token)
        }.body()

    suspend fun createPair(token: String): CreatePairResponse =
        client.post(baseUrl + "create") {
            bearerAuth(token)
        }.body()

    suspend fun getCode(token: String): String? {
        val response = client.get(baseUrl + "code") {
            bearerAuth(token)
        }
        return if (response.status == HttpStatusCode.OK) {
            response.body<GetCodeResponse>().inviteCode
        } else {
            null
        }
    }
}
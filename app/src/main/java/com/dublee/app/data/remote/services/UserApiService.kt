package com.dublee.app.data.remote.services

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.bearerAuth
import io.ktor.client.request.get
import io.ktor.client.request.patch
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json


class UserApiService {
    val baseUrl = "http://192.168.1.181:8080/api/users/"

    private val client = HttpClient {
        install(ContentNegotiation) { json(Json { ignoreUnknownKeys = true }) }
    }

    suspend fun getMe(token: String): HttpResponse =
        client.get(baseUrl + "me") {
            bearerAuth(token)
        }.body()
    suspend fun updateFcmToken(token: String, fcmToken: String): HttpResponse =
        client.patch(baseUrl + "me") {
            contentType(ContentType.Application.Json)
            setBody(mapOf("fcmToken" to fcmToken))
            bearerAuth(token)
        }
    suspend fun updateUser(iconId: Int, colorId: Int, token: String): HttpResponse =
        client.patch(baseUrl + "me") {
            contentType(ContentType.Application.Json)
            setBody(mapOf("iconId" to iconId, "colorId" to colorId))
            bearerAuth(token)
        }
    suspend fun getPartner(token: String): HttpResponse =
        client.get(baseUrl + "partner") {
            bearerAuth(token)
        }.body()
}
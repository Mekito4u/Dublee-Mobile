package com.dublee.app.data.remote.services

import com.dublee.app.data.remote.dto.LoginRequest
import com.dublee.app.data.remote.dto.RegisterRequest
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json


class AuthApiService {
    val baseUrl = "http://192.168.1.181:8080/api/auth/"

    private val client = HttpClient {
        install(ContentNegotiation) { json(Json { ignoreUnknownKeys = true }) }
    }

    suspend fun register(request: RegisterRequest): HttpResponse =
        client.post(baseUrl + "register") {
            contentType(ContentType.Application.Json)
            setBody(request)
        }.body()

    suspend fun login(request: LoginRequest): HttpResponse =
        client.post(baseUrl + "login") {
            contentType(ContentType.Application.Json)
            setBody(request)
        }.body()
}
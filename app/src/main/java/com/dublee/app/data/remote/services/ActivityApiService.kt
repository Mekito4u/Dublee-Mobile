package com.dublee.app.data.remote.services

import com.dublee.app.data.remote.dto.LikeRequest
import com.dublee.app.data.remote.dto.LikeResponse
import com.dublee.app.data.remote.dto.MatchResponse
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


class ActivityApiService {
    val baseUrl = "http://192.168.1.181:8080/api/activity/"

    private val client = HttpClient {
        install(ContentNegotiation) { json(Json { ignoreUnknownKeys = true }) }
    }

    suspend fun getLikes(token: String): List<LikeResponse> {
        return try {
            val response = client.get(baseUrl + "likes") {
                bearerAuth(token)
            }
            val body = response.body<String>()
            val list = Json.decodeFromString<List<LikeResponse>>(body)
            list
        } catch (e: Exception) {
            println(e.message.toString())
            emptyList()
        }
    }


    suspend fun getMatches(token: String): List<MatchResponse> {
        return try {
            val response = client.get(baseUrl + "matches") {
                bearerAuth(token)
            }
            val body = response.body<String>()
            val list = Json.decodeFromString<List<MatchResponse>>(body)
            list
        } catch (e: Exception) {
            println(e.message.toString())
            emptyList()
        }
    }

    suspend fun addLike(token: String, request: LikeRequest): Boolean {
        val response = client.post(baseUrl + "likes/add") {
            contentType(ContentType.Application.Json)
            setBody(request)
            bearerAuth(token)
        }
        return response.status == HttpStatusCode.OK
    }

    suspend fun deleteLike(token: String, id: Int): Boolean {
        val response = client.delete(baseUrl + "likes/$id") {
            bearerAuth(token)
        }
        return response.status == HttpStatusCode.OK
    }
}
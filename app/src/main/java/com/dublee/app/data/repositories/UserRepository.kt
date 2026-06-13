package com.dublee.app.data.repositories

import com.dublee.app.data.remote.dto.AuthResponse
import com.dublee.app.data.remote.dto.ErrorResponse
import com.dublee.app.data.remote.dto.LoginRequest
import com.dublee.app.data.remote.dto.RegisterRequest
import com.dublee.app.data.remote.dto.UserResponse
import com.dublee.app.data.remote.services.AuthApiService
import com.dublee.app.data.remote.services.UserApiService
import com.dublee.app.domain.models.UserModel
import io.ktor.client.call.body
import io.ktor.http.HttpStatusCode

open class UserRepository(
    val userApiService: UserApiService,
    val authApiService: AuthApiService,
    val tokenRepository: TokenRepository
) {
    suspend fun register(login: String, password: String): Pair<UserModel?, String?> {
        val response = authApiService.register(RegisterRequest(login, password))
        when (response.status) {
            HttpStatusCode.Created -> {
                val authResponse = response.body<AuthResponse>()
                tokenRepository.saveToken(authResponse.token)
                val user = UserModel(
                    id = authResponse.user.id,
                    login = authResponse.user.login,
                    pairId = authResponse.user.pairId,
                    iconId = authResponse.user.iconId,
                    colorId = authResponse.user.colorId
                )
                return user to null
            }

            else -> {
                val errorMessage = runCatching {
                    response.body<ErrorResponse>().message
                }.getOrNull() ?: "Ошибка"

                println("Ошибка: ${response.status}")

                return null to errorMessage
            }
        }
    }

    suspend fun login(login: String, password: String): Pair<UserModel?, String?> {
        val response = authApiService.login(LoginRequest(login, password))
        when (response.status) {
            HttpStatusCode.OK -> {
                val authResponse = response.body<AuthResponse>()
                tokenRepository.saveToken(authResponse.token)
                val user = UserModel(
                    id = authResponse.user.id,
                    login = authResponse.user.login,
                    pairId = authResponse.user.pairId,
                    iconId = authResponse.user.iconId,
                    colorId = authResponse.user.colorId
                )
                return user to null
            }

            else -> {
                val errorMessage = runCatching {
                    response.body<ErrorResponse>().message
                }.getOrNull() ?: "Ошибка"

                println("Ошибка: ${response.status}")

                return null to errorMessage
            }
        }
    }

    suspend fun getMe(): Pair<UserModel?, String?> {
        val token = tokenRepository.getToken() ?: return null to "Токен не найден!"
        val response = userApiService.getMe(token)
        when (response.status) {
            HttpStatusCode.OK -> {
                val userResponse = response.body<UserResponse>()
                val user = UserModel(
                    id = userResponse.id,
                    login = userResponse.login,
                    pairId = userResponse.pairId,
                    iconId = userResponse.iconId,
                    colorId = userResponse.colorId
                )
                return user to null
            }

            else -> {
                val errorMessage = runCatching {
                    response.body<ErrorResponse>().message
                }.getOrNull() ?: "Ошибка"

                println("Ошибка: ${response.status}")

                return null to errorMessage
            }
        }
    }

    suspend fun getPartner(): Pair<UserModel?, String?> {
        val token = tokenRepository.getToken() ?: return null to "Токен не найден!"
        val response = userApiService.getPartner(token)
        when (response.status) {
            HttpStatusCode.OK -> {
                val partnerResponse = response.body<UserResponse>()
                val partner = UserModel(
                    id = partnerResponse.id,
                    login = partnerResponse.login,
                    pairId = partnerResponse.pairId,
                    iconId = partnerResponse.iconId,
                    colorId = partnerResponse.colorId
                )
                return partner to null
            }

            else -> {
                val errorMessage = runCatching {
                    response.body<ErrorResponse>().message
                }.getOrNull() ?: "Ошибка"

                println("Ошибка: ${response.status}")

                return null to errorMessage
            }
        }
    }

    suspend fun updateUser(iconId: Int, colorId: Int): Pair<UserModel?, String?> {
        val token = tokenRepository.getToken() ?: return null to "Токен не найден!"
        val response = userApiService.updateUser(iconId, colorId, token)
        when (response.status) {
            HttpStatusCode.OK -> {
                val userResponse = response.body<UserResponse>()
                val user = UserModel(
                    id = userResponse.id,
                    login = userResponse.login,
                    pairId = userResponse.pairId,
                    iconId = userResponse.iconId,
                    colorId = userResponse.colorId
                )
                return user to null
            }

            else -> {
                val errorMessage = runCatching {
                    response.body<ErrorResponse>().message
                }.getOrNull() ?: "Ошибка"

                println("Ошибка: ${response.status}")

                return null to errorMessage
            }
        }
    }

    suspend fun getToken(): String? {
        return tokenRepository.getToken()
    }

    suspend fun sendFcmToken(fcmToken: String): Pair<Boolean?, String?> {
        val token = tokenRepository.getToken() ?: return null to "Токен не найден!"
        val response = userApiService.updateFcmToken(token, fcmToken)
        when (response.status) {
            HttpStatusCode.OK -> {
                return true to null
            }

            else -> {
                val errorMessage = runCatching {
                    response.body<ErrorResponse>().message
                }.getOrNull() ?: "Ошибка"

                println("Ошибка: ${response.status}")

                return null to errorMessage
            }
        }
    }
}
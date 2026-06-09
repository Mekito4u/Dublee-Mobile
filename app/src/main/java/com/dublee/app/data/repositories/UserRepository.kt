package com.dublee.app.data.repositories

import com.dublee.app.data.remote.dto.LoginRequest
import com.dublee.app.data.remote.dto.RegisterRequest
import com.dublee.app.data.remote.services.AuthApiService
import com.dublee.app.data.remote.services.UserApiService
import com.dublee.app.domain.models.UserModel
import com.dublee.app.domain.usecases.PartnerSession
import com.dublee.app.domain.usecases.UserSession
import kotlinx.coroutines.flow.first

open class UserRepository(
    val userSession: UserSession,
    val partnerSession: PartnerSession,
    val userApiService: UserApiService,
    val authApiService: AuthApiService,
    val tokenRepository: TokenRepository
) {
    suspend fun register(login: String, password: String): Boolean {
        return try {
            val response = authApiService.register(RegisterRequest(login, password))
            val token = response.token
            tokenRepository.saveToken(response.token)
            loadSession(
                UserModel(
                    id = response.user.id,
                    login = response.user.login,
                    pairId = response.user.pairId,
                    iconId = response.user.iconId,
                    colorId = response.user.colorId
                )
            )
            true
        } catch (e: Exception) {
            println("=== Error: ${e.message}")
            e.printStackTrace()
            return false
        }
    }

    suspend fun login(login: String, password: String): Boolean {
        return try {
            val response = authApiService.login(LoginRequest(login, password))
            val token = response.token
            tokenRepository.saveToken(token)
            loadSession(
                UserModel(
                    id = response.user.id,
                    login = response.user.login,
                    pairId = response.user.pairId,
                    iconId = response.user.iconId,
                    colorId = response.user.colorId
                )
            )
            true
        } catch (e: Exception) {
            println("=== Error: ${e.message}")
            e.printStackTrace()
            return false
        }
    }

    suspend fun getMe() {
        try {
            val token = tokenRepository.getToken() ?: return
            val response = userApiService.getMe(token)
            loadSession(
                UserModel(
                    id = response.id,
                    login = response.login,
                    pairId = response.pairId,
                    iconId = response.iconId,
                    colorId = response.colorId
                )
            )
        } catch (e: Exception) {
            println("Update user failed: ${e.message}")
        }
    }

    suspend fun updateUser(iconId: Int, colorId: Int) {
        try {
            val token = tokenRepository.getToken() ?: return
            userApiService.updateUser(iconId, colorId, token)
            val currentUser = userSession.user.value
            val updatedUser = currentUser.copy(iconId = iconId, colorId = colorId)
            userSession.loadUser(updatedUser)
        } catch (e: Exception) {
            println("Update user failed: ${e.message}")
        }
    }

    suspend fun loadSession(user: UserModel) {
        userSession.loadUser(user)
        if (user.pairId != null) {
            loadPartner()
        } else {
            partnerSession.loadPartner(UserModel.emptyPair().second)
        }
    }

    suspend fun loadPartner() {
        val token = tokenRepository.tokenFlow.first() ?: return
        try {
            val response = userApiService.getPartner(token)
            val partner = UserModel(
                id = response.id,
                login = response.login,
                pairId = response.pairId,
                iconId = response.iconId,
                colorId = response.colorId
            )
            partnerSession.loadPartner(partner)
        } catch (e: Exception) {
            println("Failed to load partner: ${e.message}")
        }
    }

    suspend fun getToken(): String? {
        return tokenRepository.getToken()
    }

    suspend fun sendFcmToken(fcmToken: String): Boolean {
        val token = tokenRepository.getToken() ?: return false
        return try {
            userApiService.updateFcmToken(token, fcmToken)
        } catch (e: Exception) {
            false
        }
    }
}
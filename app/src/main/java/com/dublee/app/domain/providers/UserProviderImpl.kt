package com.dublee.app.domain.providers

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.dublee.app.data.repositories.UserRepository
import com.dublee.app.domain.mapper.UserColorMapper
import com.dublee.app.domain.mapper.UserIconMapper
import com.dublee.app.domain.models.UserModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first

interface UserUpdater {
    suspend fun updateUser(iconId: Int, colorId: Int) {}
}

interface Session {
    val user: StateFlow<UserModel>
    val partner: StateFlow<UserModel>
}

interface UserAndPartnerLoader {
    suspend fun loadUserAndPartner()
}

interface UserIconProvider {
    fun getUserIcon(id: Int): ImageVector
    fun getColor(id: Int): Color
}

interface UserAuth {
    suspend fun register(login: String, password: String): Boolean
    suspend fun login(login: String, password: String): Boolean
    suspend fun getToken(): String?
    suspend fun clearToken()
}

interface UserFcmToken {
    suspend fun sendFcmToken(token: String)
}


class UserProviderImpl(
    val userRepository: UserRepository,
) : Session, UserIconProvider, UserUpdater, UserAndPartnerLoader, UserAuth, UserFcmToken {
    override val user = userRepository.userSession.user
    override val partner = userRepository.partnerSession.partner
    override fun getUserIcon(id: Int) = UserIconMapper.getIcon(id)
    override fun getColor(id: Int) = UserColorMapper.getColor(id)
    override suspend fun updateUser(iconId: Int, colorId: Int) {
        userRepository.updateUser(
            iconId = iconId,
            colorId = colorId
        )
    }

    override suspend fun loadUserAndPartner() {
        userRepository.getMe()
    }

    override suspend fun register(login: String, password: String): Boolean {
        return userRepository.register(login, password)
    }

    override suspend fun login(login: String, password: String): Boolean {
        return userRepository.login(login, password)
    }

    override suspend fun getToken(): String? {
        return userRepository.tokenRepository.tokenFlow.first()
    }

    override suspend fun clearToken() {
        return userRepository.tokenRepository.clearToken()
    }

    override suspend fun sendFcmToken(token: String) {
        userRepository.sendFcmToken(token)
    }

}
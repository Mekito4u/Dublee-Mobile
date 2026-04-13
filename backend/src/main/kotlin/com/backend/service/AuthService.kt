package com.backend.service

import com.backend.config.JwtUtil
import com.backend.entity.User
import com.backend.exception.UserException
import com.backend.repository.UserRepository
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class AuthService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder,
    private val jwtUtil: JwtUtil
) {
    fun register(login: String, password: String) {
        val userExists = userRepository.existsByLogin(login)
        if (userExists) throw UserException(409, "Login already exists")

        val passwordHash = passwordEncoder.encode(password)
        userRepository.save(User(login = login, password = passwordHash, name = login))
    }

    fun login(login: String, password: String): String {
        val userExists = userRepository.existsByLogin(login)
        if (!userExists) throw UserException(404, "User not found")

        val user = userRepository.findUserByLogin(login)
        if (!passwordEncoder.matches(password, user!!.password)) {
            throw UserException(401, "Wrong password")
        }

        return jwtUtil.generateToken(login)
    }
}
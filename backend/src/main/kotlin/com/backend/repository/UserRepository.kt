package com.backend.repository

import com.backend.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, Long> {
    fun existsByLogin(login: String): Boolean

    fun findUserByLogin(login:String) : User?
}
package com.backend.config

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import org.springframework.stereotype.Component
import java.util.Date

@Suppress("DEPRECATION")
@Component
class JwtUtil {
    private val secret = "mySecretKeyForDubleeApp2024VeryLongAndSecure".toByteArray()

    fun generateToken(login: String): String {
        return Jwts.builder()
            .setSubject(login)
            .setIssuedAt(Date())
            .setExpiration(Date(System.currentTimeMillis() + 86400000))
            .signWith(Keys.hmacShaKeyFor(secret))
            .compact()
    }

    fun extractLogin(token: String) : String{
        return Jwts.parserBuilder()
            .setSigningKey(Keys.hmacShaKeyFor(secret))
            .build()
            .parseClaimsJws(token)
            .body
            .subject

    }
}
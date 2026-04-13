package com.backend.exception

class UserException(
    val errorCode: Int,
    message: String
) : RuntimeException(message)


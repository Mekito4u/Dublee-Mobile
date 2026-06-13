package com.dublee.app.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class ErrorResponse(
    val message: String
)
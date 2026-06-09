package com.dublee.app.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class JoinPairRequest(
    val inviteCode: String
)

@Serializable
data class JoinPairResponse(
    val status: String
)

@Serializable
data class LeavePairResponse(
    val status: String
)

@Serializable
data class CreatePairResponse(
    val id: Int,
    val inviteCode: String,
    val user1Id: Int,
    val user2Id: Int?
)

@Serializable
data class GetCodeResponse(
    val inviteCode: String
)
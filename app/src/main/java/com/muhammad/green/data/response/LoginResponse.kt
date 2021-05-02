package com.muhammad.green.data.response

data class LoginResponse(
    val message: String,
    val status: Int,
    val token: String,
    val user: User
)
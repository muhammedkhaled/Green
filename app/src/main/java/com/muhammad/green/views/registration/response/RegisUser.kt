package com.muhammad.green.views.registration.response

data class RegisUser(
    val message: Message,
    val status: Int,
    val token: String?
)

data class Message(
    val email: List<String>,
    val phone: List<String>
)

data class RegisUserInputs(
    val name: String,
    val phone: String,
    val address: String,
    val email: String,
    val password: String,
    val city: String,
    val government_id: String,
    val password_confirmation: String,
    val address_longitude: String,
    val address_latitude: String
)
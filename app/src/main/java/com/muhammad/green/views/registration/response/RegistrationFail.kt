package com.muhammad.green.views.registration.response


data class RegistrationFail(
    val message: Message
)

data class Message(
    val email: List<String>,
    val phone: List<String>
)
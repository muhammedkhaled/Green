package com.muhammad.green.views.registration.response


data class RegistrationFail(
    val message: Message
){
    override fun toString(): String {
        return message?.email[0]?.toString() +"\n "+ message?.phone[0]?.toString()
    }
}

data class Message(
    val email: List<String>,
    val phone: List<String>
)
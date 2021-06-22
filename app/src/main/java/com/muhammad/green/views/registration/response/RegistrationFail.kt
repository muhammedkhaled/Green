package com.muhammad.green.views.registration.response


data class RegistrationFail(
    val message: Message?
) {
    override fun toString(): String {
        return if (message != null) {
            if (message.email?.get(0) != null && message.phone?.get(0) != null) {
                message.email[0] + "\n" + message.phone[0]
            }else if (message.email?.get(0) != null) {
                message.email[0].toString()
            } else if ( message.phone?.get(0) != null) {
                message.phone[0].toString()
            }else ""
        } else ""
    }
}

data class Message(
    val email: List<String?>?,
    val phone: List<String?>?
)
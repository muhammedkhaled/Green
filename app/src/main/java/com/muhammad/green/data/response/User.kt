package com.muhammad.green.data.response

data class User(
    val account_id: Int,
    val active: Int,
    val address: String,
    val address_latitude: String,
    val address_longitude: String,
    val api_token: String,
    val city: String,
    val created_at: String,
    val device_token: String,
    val email: String,
    val email_verified_at: Any,
    val government_id: Int,
    val id: Int,
    val location: String,
    val name: String,
    val phone: String,
    val photo_id: Int,
    val status: Int,
    val updated_at: String,
    val user_type_id: Int,
    val verify_code: String
)
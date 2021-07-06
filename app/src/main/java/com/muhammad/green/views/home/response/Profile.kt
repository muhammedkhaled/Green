package com.muhammad.green.views.home.response

data class Profile(
    val status: Int,
    val user: User,
    val user_case_pay: ArrayList<UserCasePay>,
    val product: ArrayList<Any>
)

data class UserCasePay(
    val address: String,
    val id: Int,
    val city: String,
    val favorite: Int,
    val government: String,
    val name: String,
    val total_collected: Int,
    val total_paid_with_auth: Int,
    val total_required: String
)

data class User(
    val account_id: String,
    val active: Int,
    val address: String,
    val address_latitude: String,
    val address_longitude: String,
    val api_token: String,
    val city: String,
    val created_at: String,
    val device_token: String,
    val email: String,
    val email_verified_at: String,
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
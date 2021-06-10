package com.muhammad.green.views.home.response

data class MyCases(
    val product: ArrayList<Any>,
    val status: Int,
    val user_case_pay: ArrayList<UserCasePay>
)

data class UserCasePay(
    val address: String,
    val city: String,
    val favorite: Int,
    val government: String,
    val name: String,
    val total_collected: Int,
    val total_paid_with_auth: Int,
    val total_required: String
)
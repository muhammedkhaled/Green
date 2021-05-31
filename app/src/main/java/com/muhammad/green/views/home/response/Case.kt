package com.muhammad.green.views.home.response

data class Case(
    val address: String,
    val city: String,
    val favorite: String,
    val government: String,
    val name: String,
    val total_collected: Int,
    val total_paid_with_auth: String,
    val total_required: String
)
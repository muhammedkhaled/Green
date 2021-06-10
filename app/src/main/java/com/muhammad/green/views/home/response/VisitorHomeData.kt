package com.muhammad.green.views.home.response

data class VisitorHomeData(
    val cases: List<UserCasePay>,
    val categories: List<Category>,
    val status: Int
)

data class Category(
    val category_id: Int,
    val created_at: String,
    val id: Int,
    val name: String,
    val photo_id: Int,
    val updated_at: String
)


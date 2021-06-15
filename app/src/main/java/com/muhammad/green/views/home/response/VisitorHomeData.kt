package com.muhammad.green.views.home.response

data class VisitorHomeData(
    val cases: ArrayList<UserCasePay>,
    val categories: ArrayList<Category>,
    val status: Int
)

data class Category(
    val category_id: Int,
    val created_at: String,
    val id: Int,
    val name: String,
    val photo_id: Int,
    val updated_at: String,
    val photo: CategoryImg
)

data class CategoryImg(
    val created_at: String,
    val id: Int,
    val name: String,
    val product_id: Any,
    val updated_at: String,
    val url: String
)
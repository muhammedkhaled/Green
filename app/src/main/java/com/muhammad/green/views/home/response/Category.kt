package com.muhammad.green.views.home.response

data class Category(
    val created_at: String,
    val id: Int,
    val name: String,
    val sub_categories: List<SubCategory>,
    val title: String,
    val updated_at: String
)
package com.muhammad.green.views.home.response

data class SubCategory(
    val category_id: Int,
    val created_at: String,
    val id: Int,
    val name: String,
    val photo_id: Int,
    val sub_sub_categories: List<SubSubCategory>,
    val updated_at: String
)
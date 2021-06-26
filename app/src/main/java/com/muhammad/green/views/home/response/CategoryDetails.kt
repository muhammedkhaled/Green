package com.muhammad.green.views.home.response

data class CategoryDetails(
    val data: ArrayList<CategoryData>,
    val status: Int
)

data class CategoryData(
    val category_id: Int,
    val created_at: String,
    val id: Int,
    val name: String,
    val sub_category_id: Int,
    val updated_at: String
){
    override fun toString(): String {
        return name
    }
}
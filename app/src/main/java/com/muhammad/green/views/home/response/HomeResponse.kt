package com.muhammad.green.views.home.response

data class HomeResponse(
    val cases: List<Case>,
    val categories: List<Category>,
    val status: Int
)
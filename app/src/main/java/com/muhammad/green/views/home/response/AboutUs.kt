package com.muhammad.green.views.home.response

data class AboutUs(
    val data: Data,
    val status: Int
)

data class Data(
    val body: String,
    val created_at: String,
    val id: Int,
    val photo: String,
    val title: String,
    val type: String,
    val updated_at: String
)
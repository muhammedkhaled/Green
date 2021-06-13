package com.muhammad.green.views.landing.response

import java.io.Serializable

data class Article(
    val content: String,
    val created_at: String,
    val id: Int,
    val title: String,
    val updated_at: String
): Serializable
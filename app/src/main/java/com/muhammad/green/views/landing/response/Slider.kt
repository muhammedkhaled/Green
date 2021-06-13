package com.muhammad.green.views.landing.response

import java.io.Serializable

data class Slider(
    val created_at: String,
    val id: Int,
    val name: String,
    val updated_at: String,
    val url: String
): Serializable
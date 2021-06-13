package com.muhammad.green.views.landing.response

data class IntroResponse(
    val articles: ArrayList<Article>,
    val sliders: ArrayList<Slider>,
    val status: Int
)
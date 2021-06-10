package com.muhammad.green.views.registration.response

data class Governments(
    val data: List<Data>,
    val cities: List<Cities>,
    val status: Int
)

data class Data(
    val id: Int,
    val name: String,
    val title: String,
) {
    override fun toString(): String {
        return name
    }
}


data class Cities(
    val id: Int,
    val name: String,
    val government_id: String,
) {
    override fun toString(): String {
        return name
    }
}
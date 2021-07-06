package com.muhammad.green.views.home.response

data class CaseFullData(
    val remain: Int,
    val status: Int,
    val total: Int,
    val user: CaseInfo
)

data class Account(
    val age: Int,
    val annuity_type: String,
    val created_at: String,
    val family_ages: String,
    val family_count: Int,
    val family_files: String,
    val id: Int,
    val id_number: String,
    val income_source: String,
    val monthly_income: String,
    val nationality: String,
    val social_status: String,
    val updated_at: String
)

data class CategoryCases(
    val data: ArrayList<Case>,
    val status: Int
)

data class Case(
    val id: Int,
    val name: String,
    val sub_sub_category: String,
    val photo: String,
    val favorite: Int
)

data class Photo(
    val created_at: String,
    val id: Int,
    val name: String,
    val product_id: Any,
    val updated_at: String,
    val url: String
)

data class CaseInfo(
    val account: Account,
    val account_id: Int,
    val active: Int,
    val address: String,
    val address_latitude: String,
    val address_longitude: String,
    val api_token: String,
    val city: String,
    val created_at: String,
    val device_token: String,
    val email: String,
    val email_verified_at: Any,
    val government_id: Int,
    val id: Int,
    val location: String,
    val name: String,
    val phone: String,
    val photo: Photo,
    val photo_id: Int,
    val status: Int,
    val updated_at: String,
    val user_type_id: Int,
    val verify_code: String
)



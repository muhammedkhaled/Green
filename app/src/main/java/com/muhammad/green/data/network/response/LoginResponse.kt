package com.muhammad.green.data.network.response

import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

data class LoginSuccess(
    val status: Int,
    val token: String,
    val user: User
)

data class LoginFail(
    val message: String,
    val status: Int
)

@Serializable
data class User(
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
    val email_verified_at: String,
    val government_id: Int,
    val id: Int,
    val location: String,
    val name: String,
    val phone: String,
    val photo_id: Int,
    val status: Int,
    val updated_at: String,
    val user_type_id: Int,
    val verify_code: String
)
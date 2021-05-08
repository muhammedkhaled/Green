package com.muhammad.green.data.network

import com.muhammad.green.data.network.response.LoginFail

sealed class ResultWrapper<out T> {

    data class Success<out T>(val value: T) : ResultWrapper<T>()

    data class GenericError(
        val isNetworkError: Boolean? = null,
        val errorCode: Int?,
        val error: LoginFail? = null
    ) : ResultWrapper<Nothing>()

    object Loading : ResultWrapper<Nothing>()
}
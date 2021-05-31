package com.muhammad.green.views.registration.repository

import com.muhammad.green.data.network.ResultWrapper
import com.muhammad.green.views.registration.response.LoginFail
import com.squareup.moshi.Moshi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


import retrofit2.HttpException
import java.io.IOException

suspend fun <T> safeApiCall(apiCall: suspend () -> T): ResultWrapper<T> {
    return withContext(Dispatchers.IO) {
        try {
            ResultWrapper.Success(apiCall.invoke())
        } catch (throwable: Throwable) {
            when (throwable) {
                is IOException -> ResultWrapper.GenericError(true, null, null)
                is HttpException -> {
                    val code = throwable.code()
                    val errorResponse = convertErrorBody(throwable)
                    ResultWrapper.GenericError( errorCode = code, error = errorResponse)
                }
                else -> {
                    ResultWrapper.GenericError(errorCode = null)
                }
            }
        }
    }
}

private fun convertErrorBody(throwable: HttpException): LoginFail? {
    return try {
        throwable.response()?.errorBody()?.source()?.let {
            val moshiAdapter = Moshi.Builder().build().adapter(LoginFail::class.java)
            moshiAdapter.fromJson(it)
        }
    } catch (exception: Exception) {
        null
    }
}

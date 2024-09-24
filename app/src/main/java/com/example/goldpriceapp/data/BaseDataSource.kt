package com.example.shahabrah.core.base

import android.util.Log
import com.google.gson.Gson
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import retrofit2.Response


suspend fun <T> calApi(call: suspend () -> Response<BaseServerResponse<T>>) = flow {

    emit(BaseApiDataState.Loading(true))

    val response = call()

    if (response.isSuccessful) {
        Log.e("calApi", "calApi: ${response.body()}")
        response.body()?.let {
            if (it.success)
                emit(BaseApiDataState.Success(it.data, it.message))
            else
                emit(BaseApiDataState.Error(it.message))




        } ?: kotlin.run {
            emit(BaseApiDataState.Error(null, "خطا در برقراری ارتباط با سرور"))
        }
    } else {
        response.errorBody()?.let {
            val errorJson = response.errorBody()?.string()
            val errorBody = Gson().fromJson(errorJson, BaseServerResponse::class.java)
            emit(BaseApiDataState.Error(errorBody.message))
        }
    }

}.catch { e ->
    emit(BaseApiDataState.Error(null, e.message.toString()))
}

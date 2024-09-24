package com.example.shahabrah.core.base

sealed class BaseApiDataState<out R> {

    data class Success<out T>(val data: T?, val messages: List<String>?) : BaseApiDataState<T>()

    data class Error(val messages: List<String>? = null, val exception: String? = null) :
        BaseApiDataState<Nothing>()


    data class Loading(val mustBeShow: Boolean) : BaseApiDataState<Nothing>()
}



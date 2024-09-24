package com.example.shahabrah.core.base

import com.google.gson.annotations.SerializedName

data class BaseServerResponse<T>(
   @SerializedName("data") val  data: T,
   @SerializedName("message") val message: List<String>?,
   @SerializedName("success") val success: Boolean
)


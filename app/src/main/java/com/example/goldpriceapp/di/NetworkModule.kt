package com.example.goldpriceapp.di


import com.example.goldpriceapp.util.Constans.BASE_URL
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory.*
import java.util.concurrent.TimeUnit

fun provideOkHttpClient(): OkHttpClient {
    return OkHttpClient.Builder()
        .connectTimeout(90, TimeUnit.SECONDS)
        .readTimeout(90, TimeUnit.SECONDS)
        .build()
}

fun provideGson(): Gson {
    return GsonBuilder()
        .setLenient()
        .create()
}





//fun createBaseNetworkClient() = retrofitClient()
//
//fun retrofitClient(): Retrofit =
//    Retrofit.Builder()
//        .baseUrl(BASE_URL)
//        .client(getOkHttpClient())
//        .addConverterFactory(create(getGson()))
//        .build()
//
//fun getOkHttpClient(): OkHttpClient {
//
//    val okHttpClient = OkHttpClient.Builder()
//        .connectTimeout(90, TimeUnit.SECONDS)
//        .readTimeout(90, TimeUnit.SECONDS)
////        .addInterceptor {
////            val oldRequest = it.request()
////            val newRequestBuilder = oldRequest.newBuilder()
////            if (UserToken.token != null)
////                newRequestBuilder.addHeader("Authorization", "Bearer ${UserToken.token!!}")
////            newRequestBuilder.addHeader("Accept", "application/json")
////            newRequestBuilder.method(oldRequest.method, oldRequest.body)
////            return@addInterceptor it.proceed(newRequestBuilder.build())
////        }
//    return okHttpClient.build()
//}
//
//private fun getGson() = GsonBuilder()
//    .setLenient()
//    .create()
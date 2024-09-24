package com.example.goldpriceapp.data.Api

import com.example.goldpriceapp.data.model.HomePageModel
import com.example.shahabrah.core.base.BaseServerResponse
import retrofit2.http.GET

interface HomeApiService {

    @GET("tgju/?license=qlX8tVREKmO0thxlpxSYDgFfZVjI1z3BjMLviXpxF1dwyJDu6WlLNIhP0py")
    suspend fun getPrices() : retrofit2.Response<BaseServerResponse<HomePageModel>>
}
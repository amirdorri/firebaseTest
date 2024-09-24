package com.example.goldpriceapp.repository

import com.example.goldpriceapp.data.Api.HomeApiService
import com.example.shahabrah.core.base.calApi
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class HomeRepo @Inject constructor(private val api : HomeApiService) {

//    suspend fun getPrices(): NetworkResult<HomePageModel> {
//        Log.d("HomeRepository", "API call getSlider")
//        return safeApiCall {
//            api.getPrices()
//        }
//    }

    suspend fun getPrices() = flow {

        calApi {
            api.getPrices()
        }.collect {
            emit(it)
        }


    }

}
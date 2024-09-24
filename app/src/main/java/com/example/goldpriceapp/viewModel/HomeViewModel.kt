package com.example.goldpriceapp.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.goldpriceapp.data.model.HomePageModel
import com.example.goldpriceapp.repository.HomeRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: HomeRepo) : ViewModel(){

//    val prices = MutableStateFlow<NetworkResult<HomePageModel>>(NetworkResult.Loading())
//
//        suspend fun getPrices() {
//
//        viewModelScope.launch {
//            prices.emit(repository.getPrices())
//        }
//    }
suspend fun getPrices()  = repository.getPrices()

}
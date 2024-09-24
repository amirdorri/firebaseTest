package com.example.goldpriceapp

import android.annotation.SuppressLint
import android.app.NotificationManager
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.NotificationCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.goldpriceapp.data.model.HomePageModel
import com.example.goldpriceapp.ui.theme.GoldPriceAppTheme
import com.example.goldpriceapp.viewModel.HomeViewModel
import com.example.shahabrah.core.base.BaseApiDataState
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GoldPriceAppTheme {

                val mViewModel = hiltViewModel<HomeViewModel>()
                val coroutineScope = rememberCoroutineScope()
                val context = LocalContext.current
                var value1 by remember { mutableStateOf("") }
                var value2 by remember { mutableStateOf("") }
                var loading by remember { mutableStateOf(false) }

//                LaunchedEffect(Unit) {
//
//                    mViewModel.getPrices().collect {
//                        when (it) {
//                            is BaseApiDataState.Loading -> {
//                                loading = true
//                            }
//
//                            is BaseApiDataState.Success -> {
//                                value1 =it.data?.gold?.current_price.toString()
//                                value2 = it.data?.gold_18k?.current_price.toString()
//                                Log.e("dorrri", it.data.toString())
//                                Log.e("dorrri", it.data?.gold?.current_price.toString())
//                                Log.e("dorrri", it.data?.gold_18k?.current_price.toString())
//
//                            }
//
//                            is BaseApiDataState.Error -> {
//                                loading = false
//                                Toast.makeText(context, it.messages.toString(), Toast.LENGTH_SHORT)
//                                    .show()
//                                Log.e("adibi", it.toString())
//
//                            }
//                        }
//                    }
//                }



                Scaffold(modifier = Modifier.fillMaxSize()) {
                  //  PriceList(value1, value2)
                    //Text(text = "Hi everyone", modifier = Modifier.padding(30.dp))


                  Button(
                      onClick = {
                          val notifManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
                          val notification = NotificationCompat
                              .Builder(context, "test")
                              .setSmallIcon(android.R.drawable.stat_notify_chat)
                              .setLargeIcon(BitmapFactory.decodeResource(resources, R.drawable.ic_launcher_background))
                              .setContentTitle("This Is A Title ")
                              .setContentText("This is the Text")
                              .build()
                          notifManager.notify((1..100).random(), notification)

                      }
                  ) {

                      Text(
                          "Send It!",
                          fontSize = 14.sp
                      )
                  }


                }
            }
        }
    }
}


@Composable
fun SwipeRefreshSection(viewModel: HomeViewModel, navController: NavHostController) {
    val refreshScope = rememberCoroutineScope()
    val swipeRefreshState = rememberSwipeRefreshState(isRefreshing = false)
    SwipeRefresh(state = swipeRefreshState,
        onRefresh = {
            refreshScope.launch {
                viewModel.getPrices()
            }
        }) {


    }

}

@Composable
fun PriceList(value2: String, value1: String) {


    Text(value2)
    Spacer(Modifier.height(22.dp))
    Text(value1)


}
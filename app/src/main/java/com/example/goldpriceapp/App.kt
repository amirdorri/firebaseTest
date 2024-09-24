package com.example.goldpriceapp

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import androidx.annotation.RequiresApi
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App(): Application() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate() {
        super.onCreate()


        val notifManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        val notifChannel = NotificationChannel("test","testName",NotificationManager.IMPORTANCE_HIGH)
        notifChannel.description = "test Description for channel"

        notifManager.createNotificationChannel(notifChannel)


    }
}
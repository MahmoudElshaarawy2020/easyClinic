package com.example.clinic.myappliction

import android.app.Application
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.clinic.shared.SharedPerferenceHelper
import views.patientViews.createAppointment

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        SharedPerferenceHelper.getInstance(this)

    }
}
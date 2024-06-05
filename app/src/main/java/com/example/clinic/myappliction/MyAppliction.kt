package com.example.clinic.myappliction

import android.app.Application
import com.example.clinic.shared.SharedPerferenceHelper

class MyAppliction : Application() {
    override fun onCreate() {
        super.onCreate()
        SharedPerferenceHelper.getInstance(this)
    }
}
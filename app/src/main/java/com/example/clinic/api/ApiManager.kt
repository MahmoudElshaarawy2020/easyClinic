package com.example.clinic.api

import android.util.Log
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiManager {


    companion object {
        private var retrofit: Retrofit? = null
        private val logger = HttpLoggingInterceptor {
            Log.e("ApiManager", "Body -> $it")
        }
            .setLevel(HttpLoggingInterceptor.Level.BODY)
        private val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(logger)
            .build()
//        val gson = GsonBuilder()
//            .setLenient()
//            .create()

        fun getService(): WebService {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl("https://zezo-yousef-taha.onrender.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build()
            }
            return retrofit!!.create(WebService::class.java)
        }
    }
}
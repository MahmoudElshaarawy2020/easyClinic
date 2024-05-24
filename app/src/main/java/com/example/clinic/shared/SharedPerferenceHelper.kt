package com.example.clinic.shared

import android.content.Context
import android.content.SharedPreferences

class SharedPerferenceHelper {

    companion object{
        private var sharedPreferences:SharedPreferences?= null

        fun getInstance(context: Context){
            sharedPreferences = context.getSharedPreferences("clinic file",Context.MODE_PRIVATE)
        }
        fun getRole():String?{
            return sharedPreferences!!.getString("role",null)
        }
        fun saveToken(role:String){
            with(sharedPreferences!!.edit()){
                putString("role",role)
                apply()
            }


        }
    }
}



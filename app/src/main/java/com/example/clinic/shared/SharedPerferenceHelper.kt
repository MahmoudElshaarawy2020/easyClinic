package com.example.clinic.shared

import android.content.Context
import android.content.SharedPreferences
import com.example.clinic.Constants

class SharedPerferenceHelper {

    companion object {
        private var sharedPreferences: SharedPreferences? = null

        fun getInstance(context: Context) {
            sharedPreferences = context.getSharedPreferences("clinic file", Context.MODE_PRIVATE)
        }

        fun getRole(): String? {
            return sharedPreferences!!.getString(Constants.ROLE, null)
        }

        fun saveRole(role: String) {
            with(sharedPreferences!!.edit()) {
                putString(Constants.ROLE, role)
                apply()
            }


        }

        fun getToken(): String? {
            return sharedPreferences!!.getString(Constants.TOKEN, null)
        }

        fun saveToken(token: String) {
            with(sharedPreferences!!.edit()) {
                putString(Constants.TOKEN, token)
                apply()
            }


        }

        fun getIdDoctor(): String? {
            return sharedPreferences!!.getString(Constants.ID_DOCTOR, null)
        }

        fun saveIdDoctor(token: String) {
            with(sharedPreferences!!.edit()) {
                putString(Constants.ID_DOCTOR, token)
                apply()
            }
        }
        fun getIdPatient(): String? {
            return sharedPreferences!!.getString(Constants.ID_PATIENT, null)
        }

        fun saveIdPatient(token: String) {
            with(sharedPreferences!!.edit()) {
                putString(Constants.ID_PATIENT, token)
                apply()
            }
        }
        fun getName(): String? {
            return sharedPreferences!!.getString(Constants.NAME, null)
        }

        fun saveName(name: String) {
            with(sharedPreferences!!.edit()) {
                putString(Constants.NAME, name)
                apply()
            }
        }
    }
}




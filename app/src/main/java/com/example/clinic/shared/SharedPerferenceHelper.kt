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

        fun getTokenAppointment(): String? {
            return sharedPreferences!!.getString(Constants.TOKEN_APPOINTMENT, null)
        }

        fun saveTokenAppointment(TokenAppointment: String) {
            with(sharedPreferences!!.edit()) {
                putString(Constants.TOKEN_APPOINTMENT, TokenAppointment)
                apply()
            }

        }
        fun getIdAppointment(): String? {
            return sharedPreferences!!.getString(Constants.ID_APPOINTMENT, null)
        }

        fun saveIdAppointment(IdAppointment: String) {
            with(sharedPreferences!!.edit()) {
                putString(Constants.ID_APPOINTMENT, IdAppointment)
                apply()
            }
        }
        fun getNewIdAppointment(): String? {
            return sharedPreferences!!.getString(Constants.NEW_ID_APPOINTMENT, null)
        }

        fun saveNewIdAppointment(NewIdAppointment: String) {
            with(sharedPreferences!!.edit()) {
                putString(Constants.NEW_ID_APPOINTMENT, NewIdAppointment)
                apply()
            }
        }
        fun getDoctorName(): String? {
            return sharedPreferences!!.getString(Constants.DOCTOR_NAME, null)
        }

        fun saveDoctorName(doctorName: String) {
            with(sharedPreferences!!.edit()) {
                putString(Constants.DOCTOR_NAME, doctorName)
                apply()
            }
        }
        fun getDoctorPrice(): String? {
            return sharedPreferences!!.getString(Constants.DOCTOR_PRICE, null)
        }

        fun saveDoctorPrice(doctorPrice: String) {
            with(sharedPreferences!!.edit()) {
                putString(Constants.DOCTOR_PRICE, doctorPrice)
                apply()
            }
        }
        fun getDoctorAddress(): String? {
            return sharedPreferences!!.getString(Constants.DOCTOR_ADDRESS, null)
        }

        fun saveDoctorAddress(doctorAddress: String) {
            with(sharedPreferences!!.edit()) {
                putString(Constants.DOCTOR_ADDRESS, doctorAddress)
                apply()
            }
        }
        fun getDoctorExperience(): String? {
            return sharedPreferences!!.getString(Constants.DOCTOR_EXPERIENCE, null)
        }

        fun saveDoctorExperience(doctorExperience: String) {
            with(sharedPreferences!!.edit()) {
                putString(Constants.DOCTOR_EXPERIENCE, doctorExperience)
                apply()
            }
        }
        fun getDoctorPhone():String?{
            return sharedPreferences!!.getString(Constants.DOCTOR_PHONE, null)
        }
        fun saveDoctorPhone(doctorPhone: String) {
            with(sharedPreferences!!.edit()) {
                putString(Constants.DOCTOR_PHONE, doctorPhone)
                apply()
            }
        }
        fun getRequestId():String?{
            return sharedPreferences!!.getString(Constants.REQUEST_APPOINTMENT_ID, null)
        }
        fun saveRequestId(requestId: String) {
            with(sharedPreferences!!.edit()) {
                putString(Constants.REQUEST_APPOINTMENT_ID, requestId)
                apply()
            }
        }
    }
}




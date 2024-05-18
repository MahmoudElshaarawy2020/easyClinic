package com.example.clinic.api

import com.example.clinic.api.models.doctor_data.DoctorDataResponse
import com.example.clinic.api.models.patient_data.DataPatientResponse
import com.example.clinic.api.models.signin.SignInResponse
import com.example.clinic.api.models.signup.SignUpResponse
import com.example.clinic.models.data.DataDoctor
import com.example.clinic.models.data.DataPatient
import com.example.clinic.models.data.SignInUser
import com.example.clinic.models.data.SignUpUser
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface WebService {

    @POST("/auth/Login")
    fun signIn(
        @Body signInUser: SignInUser
    ): Call<SignInResponse>

    @POST("/auth/signup")
    fun signUp(
        @Body signUpUser: SignUpUser
    ): Call<SignUpResponse>

    @POST("/auth/DataDoctor")
    fun DoctorData(
        @Body dataDoctor: DataDoctor
    ): Call<DoctorDataResponse>

    @POST("/auth/DataPatient")
    fun PatientData(
        @Body dataPatient: DataPatient
    ): Call<DataPatientResponse>
}
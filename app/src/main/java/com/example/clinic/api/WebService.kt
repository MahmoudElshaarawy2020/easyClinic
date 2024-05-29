package com.example.clinic.api

import com.example.clinic.api.models.doctor_data.DoctorDataResponse
import com.example.clinic.api.models.hospital.HospitalResponse
import com.example.clinic.api.models.patient_data.DataPatientResponse
import com.example.clinic.api.models.patient_doctor_data.PatientDoctorDataResponse
import com.example.clinic.api.models.signin.SignInResponse
import com.example.clinic.api.models.signup_doctor.SignUpDoctorResponse
import com.example.clinic.api.models.signup_patient.SignUpPatientResponse
import com.example.clinic.api.models.updatepatientdata.UpdatePatientDataResponse
import com.example.clinic.models.data.DataDoctor
import com.example.clinic.models.data.DataPatient
import com.example.clinic.models.data.SignInUser
import com.example.clinic.models.data.SignUpUser
import com.example.clinic.models.data.UpdatePatientData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface WebService {

    @POST("/auth/Login")
    fun signIn(
        @Body signInUser: SignInUser
    ): Call<SignInResponse>

    @POST("/auth/Signup")
    fun signUpDoctor(
        @Body signUpUser: SignUpUser
    ): Call<SignUpDoctorResponse>

    @POST("/auth/Signup")
    fun signUpPatient(
        @Body signUpUser: SignUpUser
    ): Call<SignUpPatientResponse>

    @PUT("/auth/DataDoctor")
    fun DoctorData(
        @Header("authorization") token: String = "",
        @Body dataDoctor: DataDoctor
    ): Call<DoctorDataResponse>

    @PUT("/auth/DataPatient")
    fun PatientData(
        @Header("authorization") token: String = "",
        @Body dataPatient: DataPatient
    ): Call<DataPatientResponse>

    @GET("/patient/DoctorData")
    fun getAllDoctorAvaliable(
        @Header("authorization") token: String = ""
    ): Call<PatientDoctorDataResponse>

    @PUT("/patient/PatientUpdate/{id}")
    fun updatePatientData(
        @Path("id") userId: String?,
        @Header("authorization") token: String = "", @Body updatePatientData: UpdatePatientData
    ): Call<UpdatePatientDataResponse>
}
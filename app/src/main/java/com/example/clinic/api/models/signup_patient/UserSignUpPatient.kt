package com.example.clinic.api.models.signup_patient

import com.google.gson.annotations.SerializedName

data class UserSignUpPatient(

    @field:SerializedName("role")
    val role: String? = null,

    @field:SerializedName("gender")
    val gender: String? = null,

    @field:SerializedName("forgetCode")
    val forgetCode: Any? = null,

    @field:SerializedName("diseases")
    val diseases: List<Any?>? = null,

    @field:SerializedName("isAdmin")
    val isAdmin: Boolean? = null,

    @field:SerializedName("userName")
    val userName: String? = null,

    @field:SerializedName("confirmEmail")
    val confirmEmail: Boolean? = null,

    @field:SerializedName("medicalappointments")
    val medicalappointments: List<Any?>? = null,

    @field:SerializedName("createdAt")
    val createdAt: String? = null,

    @field:SerializedName("password")
    val password: String? = null,

    @field:SerializedName("phone")
    val phone: String? = null,

    @field:SerializedName("_id")
    val id: String? = null,

    @field:SerializedName("medicalHistory")
    val medicalHistory: List<Any?>? = null,

    @field:SerializedName("email")
    val email: String? = null,

    @field:SerializedName("status")
    val status: String? = null,

    @field:SerializedName("updatedAt")
    val updatedAt: String? = null
)
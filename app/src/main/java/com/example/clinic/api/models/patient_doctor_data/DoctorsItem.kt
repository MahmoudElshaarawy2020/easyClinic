package com.example.clinic.api.models.patient_doctor_data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
data class DoctorsItem(

    @field:SerializedName("role")
    val role: String? = null,

    @field:SerializedName("gender")
    val gender: String? = null,

    @field:SerializedName("phone")
    val phone: String? = null,

    @field:SerializedName("Price")
    val price: Int? = null,

    @field:SerializedName("_id")
    val id: String? = null,

    @field:SerializedName("userName")
    val userName: String? = null,

    @field:SerializedName("Age")
    val age: Int? = null,

    @field:SerializedName("status")
    val status: String? = null,

    @field:SerializedName("token")
    val token: String? = null,

    @field:SerializedName("qualifications")
    val qualifications: String? = null
) : Parcelable
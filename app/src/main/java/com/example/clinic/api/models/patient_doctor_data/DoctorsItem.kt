package com.example.clinic.api.models.patient_doctor_data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class DoctorsItem(

	@field:SerializedName("role")
	val role: String? = null,

	@field:SerializedName("gender")
	val gender: String? = null,

	@field:SerializedName("Specialties")
	val specialties: String? = null,

	@field:SerializedName("Address")
	val address: String? = null,

	@field:SerializedName("userName")
	val userName: String? = null,

	@field:SerializedName("Section")
	val section: String? = null,

	@field:SerializedName("token")
	val token: String? = null,

	@field:SerializedName("Name")
	val name: String? = null,

	@field:SerializedName("Experience")
	val experience: String? = null,

	@field:SerializedName("phone")
	val phone: String? = null,

	@field:SerializedName("Price")
	val price: String? = null,

	@field:SerializedName("_id")
	val id: String? = null,

	@field:SerializedName("Age")
	val age: String? = null,

	@field:SerializedName("status")
	val status: String? = null,

	@field:SerializedName("Qualifications")
	val qualifications: String? = null
):Parcelable
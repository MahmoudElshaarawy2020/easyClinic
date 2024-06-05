package com.example.clinic.api.models.update_doctor_profile

import com.google.gson.annotations.SerializedName

data class Updatedoctorr(

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

	@field:SerializedName("email")
	val email: String? = null,

	@field:SerializedName("Age")
	val age: Int? = null
)
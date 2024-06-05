package com.example.clinic.api.models.signin

import com.google.gson.annotations.SerializedName

data class UserSignIn(

	@field:SerializedName("gender")
	val gender: String? = null,

	@field:SerializedName("phone")
	val phone: String? = null,

	@field:SerializedName("changePasswordTime")
	val changePasswordTime: String? = null,

	@field:SerializedName("insuranceDetails")
	val insuranceDetails: String? = null,

	@field:SerializedName("diseases")
	val diseases: List<String?>? = null,

	@field:SerializedName("_id")
	val id: String? = null,

	@field:SerializedName("userName")
	val userName: String? = null,

	@field:SerializedName("medicalappointments")
	val medicalappointments: List<Any?>? = null,

	@field:SerializedName("medicalHistory")
	val medicalHistory: List<Any?>? = null,

	@field:SerializedName("email")
	val email: String? = null
)
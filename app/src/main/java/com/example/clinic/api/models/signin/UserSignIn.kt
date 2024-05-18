package com.example.clinic.api.models.signin

import com.google.gson.annotations.SerializedName

data class UserSignIn(

	@field:SerializedName("qualifications")
	val qualifications: String? = null,

	@field:SerializedName("gender")
	val gender: String? = null,

	@field:SerializedName("phone")
	val phone: String? = null,

	@field:SerializedName("_id")
	val id: String? = null,

	@field:SerializedName("userName")
	val userName: String? = null,

	@field:SerializedName("email")
	val email: String? = null
)
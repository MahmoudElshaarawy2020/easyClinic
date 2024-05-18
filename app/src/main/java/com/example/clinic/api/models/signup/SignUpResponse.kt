package com.example.clinic.api.models.signup

import com.google.gson.annotations.SerializedName

data class SignUpResponse(

	@field:SerializedName("newDoctor")
	val userSignUp: UserSignUp? = null,

	@field:SerializedName("message")
	val message: String? = null
)
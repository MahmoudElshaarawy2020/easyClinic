package com.example.clinic.api.models.signup_doctor

import com.google.gson.annotations.SerializedName

data class SignUpDoctorResponse(

	@field:SerializedName("newDoctor")
	val userSignUpDoctor: UserSignUpDoctor? = null,

	@field:SerializedName("message")
	val message: String? = null
)
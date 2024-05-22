package com.example.clinic.api.models.signup_patient

import com.google.gson.annotations.SerializedName

data class SignUpPatientResponse(

	@field:SerializedName("newPatient")
	val userSignUpPatient: UserSignUpPatient? = null,

	@field:SerializedName("message")
	val message: String? = null
)



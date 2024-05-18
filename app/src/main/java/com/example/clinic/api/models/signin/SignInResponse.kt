package com.example.clinic.api.models.signin

import com.google.gson.annotations.SerializedName

data class SignInResponse(

	@field:SerializedName("access_token")
	val accessToken: String? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("user")
	val userSignIn: UserSignIn? = null
)
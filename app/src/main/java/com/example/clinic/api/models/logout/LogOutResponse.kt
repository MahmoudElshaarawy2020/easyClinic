package com.example.clinic.api.models.logout

import com.google.gson.annotations.SerializedName

data class LogOutResponse(

	@field:SerializedName("message")
	val message: String? = null
)
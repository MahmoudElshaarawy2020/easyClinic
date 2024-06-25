package com.example.clinic.api.models.confirm_request

import com.google.gson.annotations.SerializedName

data class ConfirmRequestResponse(

	@field:SerializedName("Mesagge")
	val mesagge: String? = null,

	@field:SerializedName("appointSear")
	val appointSear: AppointSear? = null
)
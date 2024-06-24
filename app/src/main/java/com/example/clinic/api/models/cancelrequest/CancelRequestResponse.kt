package com.example.clinic.api.models.cancelrequest

import com.google.gson.annotations.SerializedName

data class CancelRequestResponse(

	@field:SerializedName("Mesagge")
	val mesagge: String? = null,

	@field:SerializedName("appointSear")
	val appointSear: AppointSear? = null
)
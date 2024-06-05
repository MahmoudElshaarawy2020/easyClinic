package com.example.clinic.api.models.hospital

import com.google.gson.annotations.SerializedName

data class HospitalResponse(

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("getData")
	val getData: List<GetDataItem?>? = null
)
package com.example.clinic.api.models.doctor_data

import com.google.gson.annotations.SerializedName

data class DoctorDataResponse(

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("DoctorData")
	val doctorData: DoctorData? = null
)



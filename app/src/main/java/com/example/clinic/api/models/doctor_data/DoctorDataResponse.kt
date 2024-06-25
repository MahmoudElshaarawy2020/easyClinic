package com.example.clinic.api.models.doctor_data

import com.google.gson.annotations.SerializedName

data class DoctorDataResponse(

	@field:SerializedName("updatedDoctor")
	val updatedDoctor: UpdatedDoctor? = null,

	@field:SerializedName("message")
	val message: String? = null
)
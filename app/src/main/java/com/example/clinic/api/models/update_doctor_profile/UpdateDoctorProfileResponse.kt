package com.example.clinic.api.models.update_doctor_profile

import com.google.gson.annotations.SerializedName

data class UpdateDoctorProfileResponse(

	@field:SerializedName("updatedoctorr")
	val updatedoctorr: Updatedoctorr? = null,

	@field:SerializedName("message")
	val message: String? = null
)
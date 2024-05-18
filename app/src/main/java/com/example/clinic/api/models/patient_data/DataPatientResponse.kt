package com.example.clinic.api.models.patient_data

import com.google.gson.annotations.SerializedName

data class DataPatientResponse(

	@field:SerializedName("newPatientData")
	val newPatientData: NewPatientData? = null,

	@field:SerializedName("message")
	val message: String? = null
)
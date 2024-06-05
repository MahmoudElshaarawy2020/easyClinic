package com.example.clinic.api.models.medical_history

import com.google.gson.annotations.SerializedName

data class MedicalHistoryResponse(

	@field:SerializedName("MedicalHistoryy")
	val medicalHistory: MedicalHistory? = null,

	@field:SerializedName("message")
	val message: String? = null
)
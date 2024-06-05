package com.example.clinic.api.models.medical_history

import com.google.gson.annotations.SerializedName

data class MedicalHistory(

	@field:SerializedName("date")
	val date: String? = null,

	@field:SerializedName("doctorName")
	val doctorName: String? = null,

	@field:SerializedName("patientId")
	val patientId: String? = null,

	@field:SerializedName("Images")
	val images: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("_id")
	val id: String? = null,

	@field:SerializedName("Files")
	val files: String? = null
)
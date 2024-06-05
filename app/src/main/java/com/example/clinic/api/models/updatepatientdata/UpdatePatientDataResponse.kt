package com.example.clinic.api.models.updatepatientdata

import com.google.gson.annotations.SerializedName

data class UpdatePatientDataResponse(

	@field:SerializedName("updatePatient")
	val updatePatient: UpdatePatient? = null,

	@field:SerializedName("message")
	val message: String? = null
)
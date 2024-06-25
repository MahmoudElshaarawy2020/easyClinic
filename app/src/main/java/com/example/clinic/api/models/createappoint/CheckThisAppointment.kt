package com.example.clinic.api.models.createappoint

import com.google.gson.annotations.SerializedName

data class CheckThisAppointment(

	@field:SerializedName("createdAt")
	val createdAt: String? = null,

	@field:SerializedName("doctorId")
	val doctorId: String? = null,

	@field:SerializedName("patientId")
	val patientId: String? = null,

	@field:SerializedName("appointmentDateTime")
	val appointmentDateTime: String? = null,

	@field:SerializedName("_id")
	val id: String? = null,

	@field:SerializedName("status")
	val status: String? = null,

	@field:SerializedName("updatedAt")
	val updatedAt: String? = null
)
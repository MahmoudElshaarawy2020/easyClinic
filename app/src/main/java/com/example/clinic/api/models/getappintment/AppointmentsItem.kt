package com.example.clinic.api.models.getappintment

import com.google.gson.annotations.SerializedName

data class AppointmentsItem(

	@field:SerializedName("createdAt")
	val createdAt: String? = null,

	@field:SerializedName("doctorId")
	val doctorId: String? = null,

	@field:SerializedName("appointmentDateTime")
	val appointmentDateTime: String? = null,

	@field:SerializedName("_id")
	val appointmentId: String? = null,

	@field:SerializedName("status")
	val status: String? = null
)
package com.example.clinic.api.models.getappintment

import com.google.gson.annotations.SerializedName

data class getAppointmentResponse(

	@field:SerializedName("appointments")
	val appointments: List<AppointmentsItem?>? = null,

	@field:SerializedName("message")
	val message: String? = null
)
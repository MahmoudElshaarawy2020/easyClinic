package com.example.clinic.api.models.patinets_requests

import com.google.gson.annotations.SerializedName

data class PatientsRequestsResponse(

	@field:SerializedName("appointments")
	val appointments: List<AppointmentsItem?>? = null,

	@field:SerializedName("message")
	val message: String? = null
)
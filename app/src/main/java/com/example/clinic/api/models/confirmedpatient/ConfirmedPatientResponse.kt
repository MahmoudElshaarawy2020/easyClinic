package com.example.clinic.api.models.confirmedpatient

import com.google.gson.annotations.SerializedName

data class ConfirmedPatientResponse(

	@field:SerializedName("appointments")
	val appointments: List<AppointmentsItem?>? = null,

	@field:SerializedName("message")
	val message: String? = null
)
package com.example.clinic.api.models.createappoint

import com.google.gson.annotations.SerializedName

data class CreateAppointmentResponse(

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("checkThisAppointment")
	val checkThisAppointment: CheckThisAppointment? = null
)
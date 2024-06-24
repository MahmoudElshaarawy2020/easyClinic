package com.example.clinic.api.models.confirmedpatient

import com.google.gson.annotations.SerializedName

data class AppointmentsItem(

	@field:SerializedName("doctorId")
	val doctorId: String? = null,

	@field:SerializedName("patientId")
	val patientId: PatientId? = null,

	@field:SerializedName("appointmentDateTime")
	val appointmentDateTime: String? = null,

	@field:SerializedName("_id")
	val id: String? = null
)
package com.example.clinic.api.models.patient_doctor_data

import com.google.gson.annotations.SerializedName

data class PatientDoctorDataResponse(

	@field:SerializedName("doctor")
	val doctor: List<DoctorItem?>? = null,

	@field:SerializedName("message")
	val message: String? = null
)
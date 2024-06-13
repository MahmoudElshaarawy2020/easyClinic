package com.example.clinic.api.models.patient_doctor_data

import com.google.gson.annotations.SerializedName

data class PatientDoctorDataResponse(

	@field:SerializedName("doctors")
	val doctors: List<DoctorsItem?>? = null,

	@field:SerializedName("message")
	val message: String? = null
)
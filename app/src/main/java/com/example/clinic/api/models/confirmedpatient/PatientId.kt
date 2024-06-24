package com.example.clinic.api.models.confirmedpatient

import com.google.gson.annotations.SerializedName

data class PatientId(

	@field:SerializedName("gender")
	val gender: String? = null,

	@field:SerializedName("phone")
	val phone: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("diseases")
	val diseases: List<String?>? = null,

	@field:SerializedName("adress")
	val adress: String? = null,

	@field:SerializedName("_id")
	val id: String? = null,

	@field:SerializedName("medicalHistory")
	val medicalHistory: List<Any?>? = null,

	@field:SerializedName("age")
	val age: String? = null
)
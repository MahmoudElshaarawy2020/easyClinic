package com.example.clinic.api.models.confirmedpatient

import android.os.Parcelable
import com.example.clinic.api.models.medical_history.MedicalHistory
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

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
	val medicalHistory: List<MedicalHistory?>? = null,

	@field:SerializedName("age")
	val age: String? = null
)
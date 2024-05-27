package com.example.clinic.api.models.patient_doctor_data

import com.google.gson.annotations.SerializedName

data class DoctorItem(

	@field:SerializedName("role")
	val role: String? = null,

	@field:SerializedName("gender")
	val gender: String? = null,

	@field:SerializedName("forgetCode")
	val forgetCode: Any? = null,

	@field:SerializedName("isAdmin")
	val isAdmin: Boolean? = null,

	@field:SerializedName("userName")
	val userName: String? = null,

	@field:SerializedName("confirmEmail")
	val confirmEmail: Boolean? = null,

	@field:SerializedName("createdAt")
	val createdAt: String? = null,

	@field:SerializedName("password")
	val password: String? = null,

	@field:SerializedName("phone")
	val phone: String? = null,

	@field:SerializedName("Price")
	val price: Int? = null,

	@field:SerializedName("_id")
	val id: String? = null,

	@field:SerializedName("email")
	val email: String? = null,

	@field:SerializedName("Age")
	val age: Int? = null,

	@field:SerializedName("status")
	val status: String? = null,

	@field:SerializedName("updatedAt")
	val updatedAt: String? = null,

	@field:SerializedName("Address")
	val address: String? = null,

	@field:SerializedName("Section")
	val section: String? = null,

	@field:SerializedName("Name")
	val name: String? = null,

	@field:SerializedName("Experience")
	val experience: String? = null,

	@field:SerializedName("qualifications")
	val qualifications: String? = null
)
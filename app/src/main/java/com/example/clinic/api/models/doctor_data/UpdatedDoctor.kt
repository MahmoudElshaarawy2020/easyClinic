package com.example.clinic.api.models.doctor_data

import com.google.gson.annotations.SerializedName

data class UpdatedDoctor(

	@field:SerializedName("upsertedId")
	val upsertedId: Any? = null,

	@field:SerializedName("upsertedCount")
	val upsertedCount: Int? = null,

	@field:SerializedName("acknowledged")
	val acknowledged: Boolean? = null,

	@field:SerializedName("modifiedCount")
	val modifiedCount: Int? = null,

	@field:SerializedName("matchedCount")
	val matchedCount: Int? = null
)
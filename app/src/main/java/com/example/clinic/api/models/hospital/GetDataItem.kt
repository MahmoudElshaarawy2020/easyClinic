package com.example.clinic.api.models.hospital

import com.google.gson.annotations.SerializedName

data class GetDataItem(

	@field:SerializedName("HosptailAdress")
	val hosptailAdress: String? = null,

	@field:SerializedName("HosTelephone")
	val hosTelephone: String? = null,

	@field:SerializedName("HosptailName")
	val hosptailName: String? = null,

	@field:SerializedName("_id")
	val id: String? = null
)
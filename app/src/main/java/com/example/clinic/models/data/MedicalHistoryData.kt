package com.example.clinic.models.data

import android.net.Uri
import okhttp3.MultipartBody

data class MedicalHistoryData(
    val file: MultipartBody.Part?,
    val image:MultipartBody.Part?,
    val name:String,
    val patientId:String?,
    val date:String?,
    val doctorName:String?
){
}
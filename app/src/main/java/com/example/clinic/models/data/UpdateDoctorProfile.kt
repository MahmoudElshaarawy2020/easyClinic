package com.example.clinic.models.data

data class UpdateDoctorProfile(
    val userName: String?,
    val specialties: String?,
    val qualifications: String?,
    val experience: String?,
    val price: String?
) {
}
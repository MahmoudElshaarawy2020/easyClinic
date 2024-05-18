package com.example.clinic.models.data

data class DataPatient(
    val id: String,
    val name: String,
    val age: Int,
    val insuranceDetails: String,
    val diseases: String,
    val adress: String,
    val gender: String
) {
}
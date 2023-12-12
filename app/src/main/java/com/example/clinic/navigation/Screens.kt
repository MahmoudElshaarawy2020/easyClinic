package com.example.clinic.navigation

sealed class Screens(val route : String){
    object signInScreen : Screens("signIn_screen")
    object signUpScreen : Screens("signUp_screen")
    object patientProfile : Screens("patient_profile")
    object choose : Screens("choose_screen")
    object patientData  : Screens("patient_data")
    object doctorData  : Screens("doctor_data")
    object patientHome  : Screens("patient_home")

}

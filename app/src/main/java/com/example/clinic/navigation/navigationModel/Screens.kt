package com.example.clinic.navigation.navigationModel

sealed class Screens(val route : String){
    object signInScreen : Screens("signIn_screen")
    object signUpScreen : Screens("signUp_screen")
    object choose : Screens("choose_screen")
    object patientData  : Screens("patient_data")
    object doctorData  : Screens("doctor_data")
    object HospitalsRoute : Screens("hospitals")
    object MH1Route : Screens("MedHis1")
    object MH2Route : Screens("MedHis2")
    object LabsRoute : Screens("labs")
    object DietRoute : Screens("diet")
    object Nav : Screens("nav")


    //bottom navigation views
    object patientHome  : Screens("patient_home")
    object patientProfile : Screens("patient_profile")
    object Appointment : Screens("Appoint")



    fun withArgs(vararg args : String?): String{
        return buildString {
            append(route)
            args.forEach {arg ->
                append("/$arg")
            }
        }

    }

}

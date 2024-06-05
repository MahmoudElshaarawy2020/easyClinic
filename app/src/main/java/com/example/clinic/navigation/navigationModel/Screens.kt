package com.example.clinic.navigation.navigationModel

sealed class Screens(val route : String){
    object signInScreen : Screens("signIn_screen")
    object signUpScreen : Screens("signUp_screen")
    object choose : Screens("choose_screen")
    object patientData  : Screens("patient_data")
    object doctorRequests  : Screens("doctor_requests")
    object doctorProfile  : Screens("doctor_profile")
    object doctorMyProfile  : Screens("doctor_my_profile")
    object doctorHome  : Screens("doctor_home")
    object doctorData  : Screens("doctor_data")
    object HospitalsRoute : Screens("hospitals")
    object MH1Route : Screens("MedHis1")
    object MH2Route : Screens("MedHis2")
    object MA1Route : Screens("MedAppointment1")
    object MA2Route : Screens("MedAppointment2")
    object MyProfilePatientRoute : Screens("my_profile_patient")
    object LabsRoute : Screens("labs")
    object DietRoute : Screens("diet")
    object Nav : Screens("nav")
    object NavDr : Screens("navDr")




    //bottom navigation views
    object patientHome  : Screens("patient_home")
    object patientProfile : Screens("patient_profile")
    object Reservation : Screens("reservation")
    object Booking : Screens("booking")



    fun withArgs(vararg args : String?): String{
        return buildString {
            append(route)
            args.forEach {arg ->
                append("/$arg")
            }
        }

    }

}

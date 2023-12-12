package com.example.clinic.navigation


import DoctorData
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import views.ChooseRole
import views.LoginScreenTextFields
import views.PatientData
import views.PatientHome
import views.RegisterScreenTextFields
import views.patientProfile

@Composable
fun Navigation(navController: NavHostController){

    NavHost(navController = navController,
        startDestination ="signIn_screen" ){

        composable(route = "signIn_screen"){
            LoginScreenTextFields(navController = navController)
        }
        composable(route = "signUp_screen"){
            RegisterScreenTextFields(navController = navController)
        }
        composable(route = "patient_profile"){
            patientProfile(navController = navController)
        }
        composable(route = "choose_screen"){
            ChooseRole(navController = navController)
        }
        composable(route = "patient_data"){
            PatientData(navController = navController)
        }
        composable(route = "doctor_data"){
            DoctorData(navController = navController)
        }
        composable(route = "patient_home"){
            PatientHome(navController = navController)
        }
    }

}


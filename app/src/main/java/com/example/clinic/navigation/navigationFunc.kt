package com.example.clinic.navigation


import DoctorData
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import views.ChooseRole
import views.LoginScreenTextFields
import views.PatientData
import views.PatientHome
import views.RegisterScreenTextFields
import views.SplashForDoctor
import views.SplashForPatient
import views.patientProfile


@Composable
fun Navigation(navController: NavHostController) {

    NavHost(
        navController = navController,

        startDestination = Screens.AuthRoute.route
    ) {

        authGraph(navController)
        appDrGraph(navController)
        appPatientGraph(navController)



    }
}


package com.example.clinic.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import views.ChooseRole
import views.LoginScreenTextFields
import views.PatientData
import views.PatientHome
import views.RegisterScreenTextFields
import views.SplashForPatient
import views.patientProfile

fun NavGraphBuilder.appPatientGraph(navController: NavController){

    navigation(
        startDestination = Screens.patientData.route, route = Screens.AppPatientRoute.route
    ) {

        composable(route = Screens.patientData.route)
        {
            PatientData(navController = navController)
        }

        composable(
            route = "splash_patient/{name}",
            arguments = listOf(navArgument(name = "name") {
                type = NavType.StringType
                nullable = true
            })
        ) {
            SplashForPatient(name = it.arguments?.getString("name"), navController)
        }

        composable(route = Screens.patientHome.route) {
            PatientHome(navController = navController)
        }

        composable(route = Screens.patientProfile.route) {
            patientProfile(navController = navController)
        }


    }

}
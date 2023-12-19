package com.example.clinic.navigation

import DoctorData
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
import views.SplashForDoctor
import views.SplashForPatient
import views.patientProfile

fun NavGraphBuilder.appDrGraph(navController: NavController){

    navigation(startDestination = Screens.doctorData.route, route = Screens.AppDrRoute.route) {

        composable(route = Screens.doctorData.route) {
            DoctorData(navController = navController)
        }


        composable(
            route = "splash_doctor/{name}",
            arguments = listOf(navArgument(name = "name") {
                type = NavType.StringType
                nullable = true
            })
        ) {
            SplashForDoctor(name = it.arguments?.getString("name"), navController)
        }

    }

}
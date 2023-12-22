package com.example.clinic.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.example.clinic.navigationBar.Functions.MyApp
import views.ChooseRole
import views.Diet
import views.Hospitals
import views.Labs
import views.LoginScreenTextFields
import views.MedicalHistory0
import views.MedicalHistory1
import views.MedicalHistory2
import views.PatientData
import views.PatientHome
import views.RegisterScreenTextFields
import views.SplashForPatient
import views.patientProfile

fun NavGraphBuilder.appPatientGraph(navController: NavHostController){

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

        composable(route = Screens.HospitalsRoute.route) {
            Hospitals(navController = navController)
        }


        composable(route = Screens.MH1Route.route) {
            MedicalHistory1(navController = navController)
        }

        composable(route = Screens.MH2Route.route) {
            MedicalHistory2(navController = navController)
        }

        composable(route = Screens.LabsRoute.route) {
            Labs(navController = navController)
        }

        composable(route = Screens.DietRoute.route) {
            Diet(navController = navController)
        }


    }

}

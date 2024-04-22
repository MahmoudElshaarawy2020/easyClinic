package com.example.clinic.navigation.navigationModel


import views.DoctorViews.DoctorData
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.clinic.navigation.navigationBar.BottomNavModel.DrNav
import com.example.clinic.navigation.navigationBar.BottomNavModel.NavbarPatient

import views.ChooseRole
import views.Authentication.LoginScreenTextFields
import views.patientViews.PatientData
import views.Authentication.RegisterScreenTextFields
import views.DoctorViews.SplashForDoctor
import views.patientViews.SplashForPatient


@Composable
fun Navigation(navController: NavHostController) {

    NavHost(
        navController = navController,

        startDestination = Screens.signInScreen.route
    ) {

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
        composable(route = Screens.patientData.route)
        {
            PatientData(navController = navController)
        }

        composable(route = Screens.NavDr.route)
        {
            DrNav(navController = navController)
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

        composable(route = Screens.Nav.route) {
            NavbarPatient(navController = navController)
        }
        composable(route = Screens.signInScreen.route) {
            LoginScreenTextFields(navController = navController)
        }
        composable(route = Screens.signUpScreen.route) {
            RegisterScreenTextFields(navController = navController)
        }
        composable(route = Screens.choose.route) {
            ChooseRole(navController = navController)
        }



    }

}


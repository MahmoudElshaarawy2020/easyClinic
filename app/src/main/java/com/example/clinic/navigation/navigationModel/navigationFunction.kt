package com.example.clinic.navigation.navigationModel


import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.clinic.navigation.navigationBar.BottomNavModel.DrNav
import com.example.clinic.navigation.navigationBar.BottomNavModel.NavbarPatient
import com.example.clinic.shared.SharedPerferenceHelper

import views.ChooseRole
import views.Authentication.LoginScreenTextFields
import views.patientViews.PatientData
import views.Authentication.RegisterScreenTextFields
import views.doctorViews.DoctorData
import views.doctorViews.Homedoctor
import views.doctorViews.SplashForDoctor
import views.patientViews.Booking
import views.patientViews.PatientHome

import views.patientViews.SplashForPatient


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Navigation(navController: NavHostController) {

    NavHost(
        navController = navController,

        startDestination = (if (SharedPerferenceHelper.getIdDoctor()?.isNotEmpty() == true) {
            Screens.NavDr.route
        } else if (SharedPerferenceHelper.getIdPatient()?.isNotEmpty() == true) {
            Screens.Nav.route
        } else {
            Screens.signInScreen.route
        }).toString()
    ) {

        composable(route = Screens.doctorData.route) {
            DoctorData(navController = navController)
        }
        composable(route = Screens.doctorHome.route) {
            Homedoctor(navController = navController)
        }
        composable(route = Screens.patientHome.route) {
            PatientHome(navController = navController)
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


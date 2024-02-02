package com.example.clinic.navigation


import DoctorData
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.clinic.navigationBar.Functions.MyApp
import views.ChooseRole
import views.Diet
import views.Hospitals
import views.Labs
import views.LoginScreenTextFields
import views.MedicalHistory1
import views.MedicalHistory2
import views.MedicalHistory3
import views.PatientData
import views.RegisterScreenTextFields
import views.SplashForDoctor
import views.SplashForPatient


@Composable
fun Navigation(navController: NavHostController) {

    NavHost(
        navController = navController,

        startDestination = Screens.AuthRoute.route
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
            MyApp(navController = navController)
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
        composable(
            route = "MedHis3/{name1}/{name2}/{name3}",
            arguments = listOf(navArgument(name = "name1") {
                defaultValue = -1
                type = NavType.StringType


            },
                navArgument(name = "name2") {
                    defaultValue = -1
                    type = NavType.StringType


                },
                navArgument(name = "name3") {
                    defaultValue = -1
                    type = NavType.StringType


                }
            )
        )
        {
            MedicalHistory3(
                name1 = it.arguments?.getString("name1"),
                name2 = it.arguments?.getString("name2"),
                name3 = it.arguments?.getString("name3"),
                navController = navController
            )
        }

        composable(route = Screens.LabsRoute.route) {
            Labs(navController = navController)
        }

        composable(route = Screens.DietRoute.route) {
            Diet(navController = navController)
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


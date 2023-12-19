package com.example.clinic.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import views.ChooseRole
import views.LoginScreenTextFields
import views.RegisterScreenTextFields

fun NavGraphBuilder.authGraph(navController: NavController){

    navigation(startDestination = Screens.signInScreen.route, route = Screens.AuthRoute.route) {

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
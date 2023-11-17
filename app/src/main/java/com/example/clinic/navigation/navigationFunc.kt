package com.example.clinic.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.clinic.LoginScreenTextFields
import com.example.clinic.RegisterScreenTextFields

@Composable
fun Navigation(navController: NavHostController){

    NavHost(navController = navController,
        startDestination ="signIn_screen" ){

        composable(route = "signIn_screen"){
            LoginScreenTextFields(navController = navController)
        }

        composable(route = "signUp_screen"){
            RegisterScreenTextFields()

        }
    }

}


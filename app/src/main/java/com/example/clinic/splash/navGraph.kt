package com.example.clinic.splash

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun SetUpNavGraph(navController : NavHostController){
    NavHost(navController = navController, startDestination = Screen.Splash.route ){
        composable(route = Screen.Splash.route){
            AnimatedSplashScreen()
        }
        composable(route = Screen.Home.route){

        }

    }
}
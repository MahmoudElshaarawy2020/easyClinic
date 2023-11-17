package com.example.clinic.navigation

sealed class Screens(val route : String){
    object signInScreen : Screens("signIn_screen")
    object signUpScreen : Screens("signUp_screen")

}

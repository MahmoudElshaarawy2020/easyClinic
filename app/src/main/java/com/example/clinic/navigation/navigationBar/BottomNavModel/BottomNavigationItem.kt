package com.example.clinic.navigation.navigationBar.BottomNavModel

import com.example.clinic.R

sealed class BottomNavigationItem(
    val title : String,
    val route : String,
    val icon : Int
){
    object Home : BottomNavigationItem(
        title = "Home",
        route = "patient_home",
        icon = R.drawable.home1
    )
    object MyProfile : BottomNavigationItem(
        title = "My profile",
        route = "patient_profile",
        icon = R.drawable.myprofile
    )
    object Appointment : BottomNavigationItem(
        title = "Appointment",
        route = "appoint",
        icon = R.drawable.appointment
    )
}


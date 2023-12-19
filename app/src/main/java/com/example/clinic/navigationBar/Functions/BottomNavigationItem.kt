package com.example.clinic.navigationBar.Functions

import androidx.compose.ui.graphics.vector.ImageVector
import com.example.clinic.R

sealed class BottomNavigationItem(
    val title : String,
    val route : String,
    val icon : Int
){
    object Home : BottomNavigationItem(
        title = "Home",
        route = "home",
        icon = R.drawable.home
    )
    object MyProfile : BottomNavigationItem(
        title = "My profile",
        route = "my profile",
        icon = R.drawable.myprofile
    )
    object Appointment : BottomNavigationItem(
        title = "Appointment",
        route = "appointment",
        icon = R.drawable.appointment
    )
}


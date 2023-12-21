package com.example.clinic.navigationBar.Functions

import android.graphics.drawable.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
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
        route = "appointment",
        icon = R.drawable.appointment
    )
}


package com.example.clinic.navigationBar.navBarViewsPatient


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.clinic.navigation.Screens
import views.patientProfile

@Composable
fun MyProfileScreen(navController : NavController) {
    patientProfile(navController)
}
@Composable
@Preview(showBackground = true)
fun MyProfilePreview(){
    MyProfileScreen(rememberNavController())
}

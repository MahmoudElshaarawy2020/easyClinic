package com.example.clinic.navigation.navigationBar.navBarViewsPatient.navBarPatient


import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import views.PatientViews.patientProfile

@Composable
fun MyProfileScreen(navController : NavController) {
    patientProfile(navController)
}
@Composable
@Preview(showBackground = true)
fun MyProfilePreview(){
    MyProfileScreen(rememberNavController())
}

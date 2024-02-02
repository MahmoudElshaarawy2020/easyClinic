package com.example.clinic.navigation.navigationBar.navBarViewsPatient.navBarPatient

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import views.PatientViews.PatientHome

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController : NavController) {
    PatientHome (navController)
}

@Composable
@Preview(showBackground = true)
fun HomePreview(){
    HomeScreen(navController = rememberNavController())
}

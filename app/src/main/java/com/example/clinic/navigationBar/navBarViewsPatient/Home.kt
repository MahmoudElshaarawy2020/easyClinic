package com.example.clinic.navigationBar.navBarViewsPatient

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.compose.rememberNavController
import com.example.clinic.navigation.Navigation
import views.PatientHome

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

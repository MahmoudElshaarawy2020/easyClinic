package com.example.clinic.navigation.navigationBar.BottomNavModel

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.example.clinic.R
import com.example.clinic.models.data.CheckItem
import com.example.clinic.navigation.navigationModel.Screens
import com.google.gson.Gson
import views.DoctorViews.PatientDetails
import views.doctorViews.Homedoctor
import views.doctorViews.MyProfileDr
import views.doctorViews.Requests
import views.doctorViews.doctorProfile


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun DrNav(navController: NavController) {

    val navController = rememberNavController()
    val items = listOf(
        BottomNavigationItem.drRequests,
        BottomNavigationItem.drHome,
        BottomNavigationItem.drProfile
    )
    Scaffold(

        bottomBar = {
            BottomNavigation(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(88.dp)
                    .padding(vertical = 10.dp, horizontal = 5.dp)
                    .clip(RoundedCornerShape(30.dp)),
                backgroundColor = colorResource(id = R.color.light_blue)
            ) {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route

                items.forEach { screen ->
                    BottomNavigationItem(
                        icon = {
                            Image(
                                painter = painterResource(id = screen.icon),
                                contentDescription = null
                            )
                        },
                        label = { Text(text = screen.title, color = Color.White) },
                        selected = currentRoute == screen.route,
                        onClick = {
                            navController.navigate(screen.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        })

                }
            }
        }

    ) {

        NavHost(navController = navController, startDestination = Screens.NavDr.route) {
            navigation(
                startDestination = Screens.doctorHome.route,
                route = Screens.NavDr.route
            ) {
                composable(route = Screens.doctorHome.route)
                {
                    Homedoctor(navController = navController)
                }
                composable(route = Screens.doctorRequests.route)
                {
                    Requests(navController = navController)
                }
                composable(route = Screens.patientDetails.route)
                {
                    PatientDetails(checks = listOf(),navController = navController)
                }
                composable(route = Screens.doctorProfile.route)
                {
                    doctorProfile(navController = navController)
                }
                composable(route = Screens.doctorMyProfile.route)
                {
                    MyProfileDr(navController = navController)
                }

            }}}}
@Preview(showBackground = true)
@Composable
fun BottomBarDrPreview(){

    DrNav(navController = rememberNavController())
}

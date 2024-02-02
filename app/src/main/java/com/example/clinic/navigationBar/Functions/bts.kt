package com.example.clinic.navigationBar.Functions

import android.annotation.SuppressLint
import android.graphics.drawable.Icon
import android.text.style.BackgroundColorSpan
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.Navigation
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.example.clinic.R
import com.example.clinic.navigation.Navigation
import com.example.clinic.navigation.Screens
import com.example.clinic.navigation.appPatientGraph
import com.example.clinic.navigationBar.navBarViewsPatient.Appointment
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.google.android.material.bottomnavigation.BottomNavigationView
import views.PatientHome
import views.patientProfile


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun MyApp(navController: NavController) {

    val navController = rememberNavController()
    val items = listOf(
        BottomNavigationItem.Appointment,
        BottomNavigationItem.Home,
        BottomNavigationItem.MyProfile
    )
    Scaffold(

        bottomBar = {
            BottomNavigation(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(88.dp)
                    .padding(vertical = 10.dp, horizontal = 5.dp)
                    .clip(RoundedCornerShape(30.dp)),
                backgroundColor = colorResource(id = R.color.lightblue)
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

            NavHost(navController = navController, startDestination = Screens.Nav.route) {
                navigation(
                    startDestination = Screens.patientHome.route,
                    route = Screens.Nav.route
                ) {

                    composable(route = Screens.patientHome.route) {
                        PatientHome(navController = navController)

                    }

                    composable(route = Screens.patientProfile.route) {
                        patientProfile(navController = navController)
                    }

                    composable(route = Screens.Appointment.route) {
                        Appointment(navController = navController)
                    }


                }


            }
        }

    }


@Preview(showBackground = true)
@Composable
fun Previewbts(){
    MyApp(navController = rememberNavController())
}
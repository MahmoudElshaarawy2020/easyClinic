package com.example.clinic.navigation.navigationBar.BottomNavModel

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
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
import com.example.clinic.api.models.patient_doctor_data.DoctorsItem
import com.example.clinic.navigation.navigationModel.Screens
import views.patientViews.Booking
import views.patientViews.ChooseTime
import views.patientViews.Diet
import views.patientViews.Hospitals
import views.patientViews.Labs

import views.patientViews.MedicalAppointments
import views.patientViews.MedicalAppointments2

import views.patientViews.medical_history.MedicalHistory1
import views.patientViews.medical_history.MedicalHistory2
import views.patientViews.medical_history.MedicalHistory3

import views.patientViews.MyProfilePatient

import views.patientViews.PatientHome
import views.patientViews.patientProfile
import views.patientViews.reservation


@RequiresApi(Build.VERSION_CODES.O)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun NavbarPatient(navController: NavController) {

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

        NavHost(navController = navController, startDestination = Screens.Nav.route) {
            navigation(
                startDestination = Screens.patientHome.route,
                route = Screens.Nav.route
            ) {
                composable(route = Screens.patientHome.route) {
                    PatientHome(navController = navController)
                }
                composable(route = Screens.MyProfilePatient.route) {
                    MyProfilePatient(navController = navController)
                }
                composable(route = Screens.Reservation.route) {
                    reservation(navController = navController, function = {
                        navController.currentBackStackEntry?.savedStateHandle?.set("doctor", it)
                        navController.navigate(Screens.Booking.route)
                    })
                }
                composable(Screens.Booking.route) {
                    val doctor =
                        navController.previousBackStackEntry?.savedStateHandle?.get<DoctorsItem>("doctor")
                            ?: DoctorsItem("","","","","","","","","","","","","","","")
                    Booking(doctorsItem = doctor, navController = navController)
                }
            }
            composable(route = Screens.patientHome.route) {
                PatientHome(navController = navController)


            }

            composable(route = Screens.patientProfile.route) {
                patientProfile(navController = navController)
            }
            composable(route = Screens.ChooseTime.route) {
                ChooseTime( navController = navController)
            }
            composable(route = Screens.HospitalsRoute.route) {
                Hospitals(navController = navController)
            }
            composable(route = Screens.LabsRoute.route) {
                Labs(navController = navController)
            }

            composable(route = Screens.DietRoute.route) {
                Diet(navController = navController)
            }
            composable(route = Screens.MH1Route.route) {
                MedicalHistory1(navController = navController)
            }

            composable(route = Screens.MH2Route.route) {
                MedicalHistory2(navController = navController)
            }
            composable(
                route = "MedHis3/{name1}/{name2}/{name3}",
                arguments = listOf(
                    navArgument(name = "name1") {
                        defaultValue = ""
                        type = NavType.StringType


                    },
                    navArgument(name = "name2") {
                        defaultValue = ""
                        type = NavType.StringType


                    },
                    navArgument(name = "name3") {
                        defaultValue = ""
                        type = NavType.StringType


                    }
                )
            )
            {
                MedicalHistory3(
                    name1 = it.arguments?.getString("name1"),
                    name2 = it.arguments?.getString("name2"),
                    name3 = it.arguments?.getString("name3"),
                    navController = navController
                )
            }
            composable(route = Screens.MyProfilePatientRoute.route) {
                MyProfilePatient(navController = navController)
            }
            composable(route = Screens.MA1Route.route) {
                MedicalAppointments(navController = navController)
            }
            composable(route = Screens.MA2Route.route) {
                MedicalAppointments2(navController = navController)
            }


        }


    }
}


@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun BottomBarPreview() {

    NavbarPatient(navController = rememberNavController())
}
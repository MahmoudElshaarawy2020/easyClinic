package views

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

import com.example.clinic.navigation.navigationModel.Navigation

import com.example.clinic.ViewModel.MainViewModel
import com.example.clinic.shared.SharedPerferenceHelper


class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels()
    lateinit var navController: NavHostController

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        installSplashScreen().apply {
            viewModel.isLoading.value
        }
        setContent {
            CheckeRole()
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @Composable
    private fun CheckeRole() {
            navController = rememberNavController()
            Navigation(navController = navController)
    }

}


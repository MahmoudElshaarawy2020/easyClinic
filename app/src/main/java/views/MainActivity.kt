package views

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.clinic.R
import com.example.clinic.navigation.Navigation
import com.example.clinic.splashScreenStuff.MainViewModel


class MainActivity : ComponentActivity() {
    private val viewModel : MainViewModel by viewModels()
    lateinit var navController : NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        val fontFamily = FontFamily(
            Font(R.font.audiowideregular, FontWeight.Thin)
        )
        installSplashScreen().apply {
            setKeepVisibleCondition{
                viewModel.isLoading.value
            }
        }
        setContent {

                navController = rememberNavController()
                Navigation(navController = navController)


        }
    }
}


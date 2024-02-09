package views

//import QuranRequestBody
//import QuranResponse
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.clinic.navigation.navigationModel.Navigation
//import com.example.clinic.network.ApisClient
//import com.example.clinic.network.ApisClient
//import com.example.clinic.network.QuranRequestBody
//import com.example.clinic.network.QuranResponse
import com.example.clinic.splashScreenModel.MainViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels()
    lateinit var navController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        installSplashScreen().apply {
            viewModel.isLoading.value

        }
        setContent {

            navController = rememberNavController()
            Navigation(navController = navController)


        }

//       ApisClient.getMyClientServices().getMySuras(quranBody = QuranRequestBody(reader_id = 25))
//           .enqueue(object :
//               Callback<QuranResponse> {
//               override fun onResponse(
//                   call: Call<QuranResponse>?,
//                   response: Response<QuranResponse>?
//               ) {
//                   if (response?.isSuccessful == true)
//                       Log.i("MY_SURAS", response?.body()?.data?.firstOrNull()?.sora.toString())
//               }
//
//               override fun onFailure(call: Call<QuranResponse>?, t: Throwable?) {
//                   Log.i("MY_SURAS", t?.message.toString())
//               }
//
//           })
    }}


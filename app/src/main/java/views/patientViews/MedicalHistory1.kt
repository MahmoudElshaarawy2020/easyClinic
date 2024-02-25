package views.patientViews
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.clinic.R
import views.FunctionsComposable.LocalImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MedicalHistory1(navController: NavController){
    val fontFamily = FontFamily(
        Font(R.font.wendyoneregular, FontWeight.Thin))

    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = Color(0xFFE9FAFF)),
        ){


        Box(modifier = Modifier
            .fillMaxWidth()
            .size(100.dp)
            .background(color = Color(0xFF2697FF))){
            Text(text = "Medical history",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 70.dp, top = 25.dp),

                color = Color(0xFFFFFFFF),
                textAlign = TextAlign.Start,
                fontFamily = fontFamily,
                fontSize = 26.sp)


            Box(modifier = Modifier

                .padding(10.dp)
                .clickable {
                    navController.navigate(route = "patient_profile")

                }) {
                LocalImage(
                    painter = painterResource(id = R.drawable.whitearrow), imageSize = 60.dp,
                    padding = 10.dp
                )
            }
        }
        Column(modifier = Modifier
            .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            LocalImage(painter = painterResource(id = R.drawable.microscoope),
                imageSize = 150.dp,
                padding =0.dp )
            Text(modifier = Modifier.fillMaxWidth(),
                text = "Medical tests have not \n been added yet",
                fontSize = 24.sp,
                color = Color(0xFF646E82),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.fillMaxWidth()
                .size(20.dp))
            Box(modifier = Modifier
                .clickable { navController.navigate(route = "MedHis2"){
                    popUpTo("MedHis1"){
                        inclusive = true
                    }
                } }){
                LocalImage(painter = painterResource(id = R.drawable.plus),
                    imageSize = 100.dp,
                    padding = 0.dp )
            }
        }


    }

}



@Composable
@Preview(showBackground = true)
fun MedicalHistory1Prview(){
    MedicalHistory1(navController = rememberNavController())
}
